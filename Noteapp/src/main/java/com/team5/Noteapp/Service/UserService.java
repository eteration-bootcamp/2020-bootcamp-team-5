package com.team5.Noteapp.Service;

import com.team5.Noteapp.Dto.UserDto;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.UserInfoRepository;
import com.team5.Noteapp.Repository.UserRepository;
import com.team5.Noteapp.Util.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private LocalValidatorFactoryBean validator;

    public void auth() {

    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User getUserByUserInfo(String username, String pass) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findByUsernameAndPassword(username, pass);
        Optional<User> user = null;
        if (userInfoOptional.isPresent()) {
            if (userInfoOptional.get().isActive()) {
                user = userRepository.findById(userInfoOptional.get().getUser().getId());
                if (user.isPresent()) {
                    return user.get();
                }
            }
        }
        throw new IllegalArgumentException("Specified user does not exists!");
    }

    public String login(UserInfo userInfo) {
        User user = this.getUserByUserInfo(userInfo.getUsername(), hashCodeService.createPasswordHash(userInfo.getPassword()));
        if (user != null) {
            return hashCodeService.createLoginHash(user);
        } else return null;
    }

    public String signup(UserDto userDto) {
        UserInfo userInfo = new UserInfo();
        User user = new User();
        StringBuilder stringBuilder = new StringBuilder();
        if (userDto != null) {
            Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
            violations.forEach(violation -> {
                stringBuilder.append(violation.getMessage() + "\n");
            });
            if(stringBuilder.length() >= 2)
                stringBuilder.setLength(stringBuilder.length() - 1);
            if (!violations.isEmpty()) {
                return stringBuilder.toString();
            }
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setMail(userDto.getMail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            userInfo.setUsername(userDto.getUsername());
            userInfo.setActive(false);
            userInfo.setPassword(hashCodeService.createPasswordHash(userDto.getPassword()));
            userInfo.setUser(user);
            try {
                userInfoRepository.save(userInfo);
                userRepository.save(user);
            } catch (Exception e) {
                throw new IllegalArgumentException("User already exists!");
            }
            this.sendMailForAccountActivation(userDto.getMail());
        } else return "Invalid registration data!";
        return "Signed up succesfully! Please check your mail.";
    }

    public void sendMailForResetPassword(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            String hashCode = hashCodeService.createResetPasswordHash(userOptional.get());
            String url = "http://noteration.azurewebsites.net/new-password/" + hashCode;
            String content = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "    <body style=\"background-color: #202c39;\">\n" +
                    "        <div style=\"text-align: center;\">\n" +
                    "            <img src=\"http://noteration.azurewebsites.net/noteration-logo.png\" alt=\"Noteration Logo\" width=\"200\" height=\"100\">\n" +
                    "                <br>\n" +
                    "                <div style=\"text-align: center;\">\n" +
                    "                    <a href=\""+ url +"\">\n" +
                    "                        <button style=\"border-radius: 10px;width: 100px;height: 40px;background-color: #FBFAF8;\">Reset password.</button>\n" +
                    "                    </a>\n" +
                    "                </div>\n" +
                    "                <br>\n" +
                    "                <br>\n" +
                    "                </div>\n" +
                    "        <div style=\"text-align: center; color:#FBFAF8;\">\n" +
                    "            Noteration 2020, all rights reserved by Spreaction.   </div>\n" +
                    "    </body>\n" +
                    "</html>";
            mailService.sendMail(email, content, "Reset your Noteration account's password! :)");
        } else throw new IllegalArgumentException("Email is not correct!");
    }

    public void sendMailForAccountActivation(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            String hashCode = hashCodeService.createActivationHash(userOptional.get());
            String url = "http://noteration.azurewebsites.net/activate-account/" + hashCode;
            String content = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "    <body style=\"background-color: #202c39;\">\n" +
                    "        <div style=\"text-align: center;\">\n" +
                    "            <img src=\"http://noteration.azurewebsites.net/noteration-logo.png\" alt=\"Noteration Logo\" width=\"200\" height=\"100\">\n" +
                    "                <br>\n" +
                    "                <div style=\"text-align: center;\">\n" +
                    "                    <a href=\""+ url +"\">\n" +
                    "                        <button style=\"border-radius: 10px;width: 100px;height: 40px;background-color: #FBFAF8;\">Activate your account.</button>\n" +
                    "                    </a>\n" +
                    "                </div>\n" +
                    "                <br>\n" +
                    "                <br>\n" +
                    "                </div>\n" +
                    "        <div style=\"text-align: center; color:#FBFAF8;\">\n" +
                    "            Noteration 2020, all rights reserved by Spreaction.   </div>\n" +
                    "    </body>\n" +
                    "</html>";
            mailService.sendMail(email, content, "Activate your Noteration account! :)");
        } else throw new IllegalArgumentException("Email is not correct!");
    }
}

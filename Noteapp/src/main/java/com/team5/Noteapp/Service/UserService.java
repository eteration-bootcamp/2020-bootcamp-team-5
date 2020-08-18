package com.team5.Noteapp.Service;

import com.team5.Noteapp.Dto.UserDto;
import com.team5.Noteapp.Entity.HashCode;
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

    public String login(UserInfo userInfo) throws Exception {
        User user = this.getUserByUserInfo(userInfo.getUsername(), hashCodeService.createPasswordHash(userInfo.getPassword()));
        HashCode hashCode;
        if (user != null) {
            hashCode = hashCodeService.createLoginHash(user);
            return hashCode.getCode();
        } else return null;
    }

    public String signup(UserDto userDto) {
        UserInfo userInfo = new UserInfo();
        User user = new User();
        if (userDto != null) {
            Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
            violations.forEach(violation -> {
                System.out.println(violation.getMessage());
            });
            if (!violations.isEmpty()) {
                throw new IllegalArgumentException("XD");
            }
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setMail(userDto.getMail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            userInfo.setUsername(userDto.getUsername());
            userInfo.setActive(false);
            userInfo.setPassword(hashCodeService.createPasswordHash(userDto.getPassword()));
            userInfo.setUser(user);
            userInfoRepository.save(userInfo);
            userRepository.save(user);
            this.sendMailForAccountActivation(userDto.getMail());
            System.out.println(userRepository.findById(user.getId()).toString());
            System.out.println(userInfoRepository.findById(userInfo.getId()).toString());
            return "Signup successful!";
        } else return "Signup failed!";
    }

    public void sendMailForResetPassword(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            String hashCode = hashCodeService.createResetPasswordHash(userOptional.get());
            String url = "http://localhost/new-password/" + hashCode;
            String content = "<a href='" + url + "'>" + url + "</a>";
            mailService.sendMail(email, content, "Reset your Noteration account's password! :)");
        }
    }

    public void sendMailForAccountActivation(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            String hashCode = hashCodeService.createActivationHash(userOptional.get());
            String url = "http://localhost/activate-account/" + hashCode;
            String content = "<a href='" + url + "'>" + url + "</a>";
            mailService.sendMail(email, content, "Activate your Noteration account! :)");
        }
    }
}

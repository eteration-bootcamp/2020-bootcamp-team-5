package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Dto.UserDto;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.ResetRepository;
import com.team5.Noteapp.Repository.UserInfoRepository;
import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserService;
import com.team5.Noteapp.Util.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private ResetRepository resetRepository;

    @PostMapping("/login")
    public String login(@RequestBody UserInfo userInfo) throws Exception {
        return userService.login(userInfo);
    }

    @RequestMapping(value = "/logout")
    public void logout(@RequestParam String hashCode) {
        hashCodeService.deleteLoginHash(hashCode);
    }

    @PostMapping(value = "/signup")
    public void signup(@RequestBody UserDto userDto, HttpServletResponse httpServletResponse) throws IOException {
        try {
            userService.signup(userDto);
        }catch (Exception e){
            httpServletResponse.sendError(400, "JUNG DIFF");
        }
    }

    @PostMapping(value = "/forgot-password")
    public void forgotPassword(@RequestParam String username)  {
        mailService.sendMail(username);
    }

    @RequestMapping(value = "/new-password/{resetCode}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void newPassword(@PathVariable int resetCode, @RequestBody String newPassword){
        System.out.println(newPassword);
        //TODO find user with resetCode and set new Password
        Optional<UserInfo> userInfo = userInfoRepository.findById(resetRepository.findUserInfoIdByResetCode(resetCode).get());
        userInfo.get().setPassword(hashCodeService.createPasswordHash(newPassword));
        userInfoRepository.save(userInfo.get());
    }

    @GetMapping("/auth")
    public void auth(){

    }
}
package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Dto.UserDto;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserService;
import com.team5.Noteapp.Util.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

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
    public void forgotPassword(@RequestParam String to, @RequestParam String subject,
                               @RequestParam String emailBody)  {
        mailService.sendMail(to, subject, emailBody);
    }

    @GetMapping("/new-password")
    public String newPassword(){
        return "SUCCESS";
    }
}
package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Dto.UserDto;
import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserInfoService;
import com.team5.Noteapp.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

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
            httpServletResponse.sendError(401, "JUNG DIFF");
        }
    }

    @PostMapping(value = "/forgot-password")
    public void forgotPassword(@RequestParam String email)  {
        userService.sendMailForResetPassword(email);
    }

    //TODO DELETE HASH
    @RequestMapping(value = "/new-password/{hashCode}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String newPassword(@PathVariable String hashCode, @RequestBody String newPassword, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println(newPassword);
        HashCode hashCodeObj = hashCodeService.findHashCode(hashCode);
        try{
            if(hashCodeObj.getType().equals("Reset") && hashCodeObj.getExDate().getTime() > System.currentTimeMillis()){
                userInfoService.resetPassword(hashCodeObj.getUserId(), newPassword);
                hashCodeService.deleteHashCode(hashCodeObj.getUserId());
            }return "New password has been set";
        } catch (Exception e){
            httpServletResponse.sendError(401);
            return "Failed to reset password";
        }
    }

    @PostMapping("/activate-account/{hashCode}")
    public String activateAccount(@PathVariable String hashCode, HttpServletResponse httpServletResponse) throws IOException {
        HashCode hashCodeObj = hashCodeService.findHashCode(hashCode);
        try{
            if (hashCodeObj.getType().equals("Activation") && hashCodeObj.getExDate().getTime() > System.currentTimeMillis()){
                userInfoService.activateAccount(hashCodeObj.getUserId());
            }return "Your account has been activated";
        }catch (Exception e){
            httpServletResponse.sendError(401);
            return "Couldn't activate your account";
        }
    }

    @GetMapping("/auth")
    public void auth(){

    }
}
package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String pass, HttpServletResponse httpServletResponse) throws Exception {
        try {
            userService.login(username, pass);
        }catch (Exception e){
            httpServletResponse.sendError(400, "Login failed!");
        }
    }

    @PostMapping("/logout")
    public void logout(@RequestAttribute String hashCode) {
            hashCodeService.deleteLoginHash(hashCode);
    }
}

package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestAttribute String username, @RequestAttribute String pass, HttpServletResponse httpServletResponse) throws Exception {
        User user = userService.getUserByUserInfo(username, hashCodeService.passwordHash(pass));
        HashCode hashCode;
        if(user != null) {
            hashCode = hashCodeService.createLoginHash(user);
            return hashCode.getCode();
        }
        else{
            httpServletResponse.sendError(400, "Login failed!");
           return null;
        }
    }
}

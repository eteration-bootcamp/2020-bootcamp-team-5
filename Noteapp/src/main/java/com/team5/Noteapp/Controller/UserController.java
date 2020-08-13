package com.team5.Noteapp.Controller;

import com.team5.Noteapp.Service.HashCodeService;
import com.team5.Noteapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private HashCodeService hashCodeService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String pass, HttpServletResponse httpServletResponse) throws Exception {
            return userService.login(username, pass);
    }

    @RequestMapping(value = "/logout")
    public void logout(@RequestAttribute(required = false, value = "hashCode") String hashCode) {
            hashCodeService.deleteLoginHash(hashCode);
    }
}

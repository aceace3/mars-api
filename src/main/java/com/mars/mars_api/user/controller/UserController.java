package com.mars.mars_api.user.controller;

import com.mars.mars_api.user.bean.User;
import com.mars.mars_api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password,
                                     HttpServletRequest request,
                                     HttpServletResponse response){
        User u = userService.login(userName, password);
        Map<String, String> result = new HashMap<>();
        if (u != null){
            request.getSession().setAttribute("users", u);
            request.getSession().setMaxInactiveInterval(-1); //永不过期

            result.put("status", "ojbk");
            return result;
        }
        result.put("status", "notOjbk");
        return result;
    }

    @GetMapping("/logout")
    @ResponseBody
    public void logout(HttpServletRequest request, HttpServletResponse response){
        User u = (User) request.getSession().getAttribute("users");
        request.getSession().removeAttribute("users");
    }
}

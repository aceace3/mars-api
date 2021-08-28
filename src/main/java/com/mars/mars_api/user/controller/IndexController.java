package com.mars.mars_api.user.controller;

import com.mars.mars_api.user.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * login页面
     * */
    @RequestMapping ("/index")
    public String indexPage(){
        return "login";
    }

    @RequestMapping ("/success")
    public String successPage(){
        return "success";
    }

    @RequestMapping ("/errorPage")
    public String errorPage(){
        return "error";
    }

    @RequestMapping ("/test")
    public String test(Model model){
        model.addAttribute("testname","zhaoyi");
        return "test";
    }

    @RequestMapping ("/mainPage")
    public String mainPage(Model model, HttpSession session){
        User u = (User) session.getAttribute("users");
        model.addAttribute("username", u.getUserName());
        return "main";
    }

}

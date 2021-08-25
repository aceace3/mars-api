package com.mars.mars_api.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

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
    public String test(){
        return "test";
    }


}

package com.mars.mars_api.sysapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/addApi")
    public String test(Model model){
        return "addApi";
    }

}

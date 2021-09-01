package com.mars.mars_api.sysapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/addApi")
    public String addApi(Model model){
        return "addApi";
    }

    @RequestMapping("/editSysApiPage")
    public String editSysApiPage(){
        return "editSysApiPage";
    }

    @RequestMapping("/copySysApiPage")
    public String copySysApiPage(){
        return "copySysApiPage";
    }

}

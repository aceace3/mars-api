package com.mars.mars_api.sysapi.controller;

import com.mars.mars_api.sysapi.bean.dto.SysApiDTO;
import com.mars.mars_api.sysapi.service.SysApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sysApi")
public class SysApiController {

    @Autowired
    SysApiService sysApiService;

    /**
     * 左侧目录
     * */
    @ResponseBody
    @GetMapping("/getSysApi")
    public List<SysApiDTO> getSysApi(){
        return sysApiService.getSysApi();
    }

    /**
     * 详细 api/dataDic
     * */
    @ResponseBody
    @GetMapping("/selectById")
    public SysApiDTO selectById(@RequestParam("id") Integer id){
        SysApiDTO sysApiDTO = sysApiService.selectById(id);
        if (sysApiDTO != null){
            return sysApiDTO;
        }
        return null;
    }
}

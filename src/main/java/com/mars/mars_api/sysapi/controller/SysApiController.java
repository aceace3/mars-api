package com.mars.mars_api.sysapi.controller;

import com.mars.mars_api.sysapi.bean.SysApi;
import com.mars.mars_api.sysapi.bean.dto.DirDTO;
import com.mars.mars_api.sysapi.bean.dto.SysApiDTO;
import com.mars.mars_api.sysapi.service.SysApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 下拉目录
     * */
    @ResponseBody
    @GetMapping("/getSelectDir")
    public List<DirDTO> getDir(){
        return sysApiService.getDir(0);
    }

    /**
     * 保存数据
     * */
    @ResponseBody
    @PostMapping("/saveSysApi")
    public String saveSysApi(@RequestBody SysApi sysApi, HttpServletRequest request){
        return sysApiService.saveSysApi(sysApi, request);
    }

    /**
     * 删除数据
     * */
    @ResponseBody
    @GetMapping("/delSysApi")
    public String delSysApi(@RequestParam("id") Integer id, HttpServletRequest request){
        return sysApiService.delSysApi(id, request);
    }

    /**
     * 根据id 查询数据
     * */
    @ResponseBody
    @GetMapping("/getApiById")
    public SysApi getApiById(@RequestParam("id") Integer id){
        return sysApiService.getApiById(id);
    }

    /**
     * 编辑数据
     * */
    @ResponseBody
    @PostMapping("/editSysApi")
    public String editSysApi(@RequestBody SysApi sysApi, HttpServletRequest request){
        return sysApiService.editSysApi(sysApi, request);
    }

}

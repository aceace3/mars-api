package com.mars.mars_api.history.service;

import com.mars.mars_api.history.bean.SysHistory;
import com.mars.mars_api.history.mapper.SysHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysHistoryService {

    @Autowired
    SysHistoryMapper sysHistoryMapper;

    public String addHistory(SysHistory sysHistory){
        if (sysHistoryMapper.addHistory(sysHistory) > 0){
            return "ok";
        }
        return "not ok";
    }

}

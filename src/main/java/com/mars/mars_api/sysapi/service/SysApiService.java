package com.mars.mars_api.sysapi.service;

import com.mars.mars_api.sysapi.bean.SysApi;
import com.mars.mars_api.sysapi.bean.dto.SysApiDTO;
import com.mars.mars_api.sysapi.mapper.SysApiMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.mars_api.sysapi.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysApiService {

    @Autowired
    SysApiMapper sysApiMapper;

    public List<SysApiDTO> getSysApi(){
        //全部数据
        List<SysApi> sysApiList = sysApiMapper.getSysApi();

        //转格式
        List<SysApiDTO> dtoList = new ArrayList<>();
        for (SysApi sa : sysApiList) {
            SysApiDTO dto = new SysApiDTO();
            BeanUtils.copyProperties(sa, dto);
            dtoList.add(dto);
        }

        //转树
        List<SysApiDTO> sysApiDTOS = TreeUtils.toTree(dtoList);
        return sysApiDTOS;
    }

    public SysApiDTO selectById(Integer id){
        return sysApiMapper.selectById(id);
    }
}

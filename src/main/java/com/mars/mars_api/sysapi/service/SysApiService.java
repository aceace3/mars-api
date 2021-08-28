package com.mars.mars_api.sysapi.service;

import com.mars.mars_api.sysapi.bean.SysApi;
import com.mars.mars_api.sysapi.bean.dto.DirDTO;
import com.mars.mars_api.sysapi.bean.dto.SysApiDTO;
import com.mars.mars_api.sysapi.mapper.SysApiMapper;
import com.mars.mars_api.sysapi.utils.DirTreeUtils;
import com.mars.mars_api.user.bean.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.mars_api.sysapi.utils.TreeUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SysApiService {

    @Autowired
    SysApiMapper sysApiMapper;

    public List<SysApiDTO> getSysApi(){
        //全部数据
        List<SysApi> sysApiList = sysApiMapper.getSysApi(null, null);

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

    public List<DirDTO> getDir(Integer isLeaf){
        //全部数据
        List<SysApi> sysApiList = sysApiMapper.getSysApi(isLeaf, null);

        System.out.println(sysApiList);

        //转格式
        List<DirDTO> dtoList = new ArrayList<>();
        for (SysApi sa : sysApiList) {
            DirDTO dirDTO = new DirDTO();
            dirDTO.setId(sa.getId());
            dirDTO.setPid(sa.getPid());
            dirDTO.setName(sa.getTitle());
            dirDTO.setOpen(false);
            dtoList.add(dirDTO);
        }

        //转树
        List<DirDTO> dirDTOSDTOS = DirTreeUtils.toTree(dtoList);
        return dirDTOSDTOS;
    }

    public String saveSysApi(SysApi sysApi, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("users");
        Integer createBy = user.getId();

        sysApi.setCreateBy(createBy);
        Date createTime = new Date();
        sysApi.setCreateTime(createTime);
        sysApi.setIsLeaf(1);

        if (sysApiMapper.saveSysApi(sysApi) > 0){
            return "保存成功";
        }
        return "保存失败";
    }

    public String delSysApi(Integer id){
        if (sysApiMapper.delSysApi(id) > 0){
            return "删除成功";
        }
        return "删除失败";
    }

    public SysApi getApiById(Integer id){
        return sysApiMapper.getSysApi(null, id).get(0);
    }
}

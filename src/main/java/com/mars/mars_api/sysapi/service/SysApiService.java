package com.mars.mars_api.sysapi.service;

import com.mars.mars_api.history.bean.SysHistory;
import com.mars.mars_api.history.mapper.SysHistoryMapper;
import com.mars.mars_api.history.service.SysHistoryService;
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

    @Autowired
    SysHistoryService sysHistoryService;

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

    public String delSysApi(Integer id, HttpServletRequest request){
        try {
            SysHistory history = this.makeHistory(this.getApiById(id), request);
            sysHistoryService.addHistory(history);
            sysApiMapper.delSysApi(id);
            return "删除成功";

        }catch (Exception e){
            System.out.println(e);
            return "删除失败";

        }
    }

    public SysApi getApiById(Integer id){
        return sysApiMapper.getSysApi(null, id).get(0);
    }

    private SysHistory makeHistory(SysApi sysApi, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("users");
        Integer createBy = user.getId();

        SysHistory history = new SysHistory();
        history.setApiId(sysApi.getId());
        history.setTitle(sysApi.getTitle());
        history.setCreateBy(sysApi.getCreateBy());
        history.setContent(sysApi.getContent());
        history.setPid(sysApi.getPid());
        history.setCreateTime(sysApi.getCreateTime());
        history.setIsLeaf(sysApi.getIsLeaf());
        history.setUpdateTime(new Date());
        history.setUpdateUser(createBy);
        history.setOgContent(sysApi.getOgContent());

        return history;
    }

    public String editSysApi(SysApi sysApi, HttpServletRequest request){
        try {
            User user = (User)request.getSession().getAttribute("users");
            Integer createBy = user.getId();
            sysApi.setCreateBy(createBy);
            sysApi.setCreateTime(new Date());

            SysHistory history = this.makeHistory(this.getApiById(sysApi.getId()), request);
            sysHistoryService.addHistory(history);
            sysApiMapper.editSysApi(sysApi);
            return "编辑成功";

        }catch (Exception e){
            System.out.println(e);
            return "编辑失败";

        }
    }
}

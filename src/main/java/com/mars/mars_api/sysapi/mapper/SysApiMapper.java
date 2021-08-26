package com.mars.mars_api.sysapi.mapper;

import com.mars.mars_api.sysapi.bean.SysApi;
import com.mars.mars_api.sysapi.bean.dto.SysApiDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysApiMapper {

    List<SysApi> getSysApi();

    SysApiDTO selectById(@Param("id")Integer id);
}

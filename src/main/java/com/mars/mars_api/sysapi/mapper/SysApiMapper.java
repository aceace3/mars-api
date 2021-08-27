package com.mars.mars_api.sysapi.mapper;

import com.mars.mars_api.sysapi.bean.SysApi;
import com.mars.mars_api.sysapi.bean.dto.SysApiDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysApiMapper {

    List<SysApi> getSysApi(@Param("isLeaf")Integer isLeaf);

    SysApiDTO selectById(@Param("id")Integer id);

    Integer saveSysApi(SysApi sysApi);

}

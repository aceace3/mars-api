package com.mars.mars_api.history.mapper;

import com.mars.mars_api.history.bean.SysHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysHistoryMapper {

    Integer addHistory(SysHistory sysHistory);

}

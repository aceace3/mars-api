package com.mars.mars_api.user.mapper;

import com.mars.mars_api.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserByNameNdPassword(@Param("username")String username, @Param("password")String password);

}

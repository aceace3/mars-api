package com.mars.mars_api.user.service;

import com.mars.mars_api.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Boolean login(String username, String password){
        if (userMapper.getUserByNameNdPassword(username, password) != null){
            return true;
        }
        return false;
    }
}

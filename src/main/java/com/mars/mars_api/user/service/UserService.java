package com.mars.mars_api.user.service;

import com.mars.mars_api.user.bean.User;
import com.mars.mars_api.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User login(String username, String password){
        User u = userMapper.getUserByNameNdPassword(username, password);
        if (u != null){
            return u;
        }
        return null;
    }
}

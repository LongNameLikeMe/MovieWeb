package com.web.movie.service.impl;

import com.web.movie.entity.User;
import com.web.movie.entity.UserInfo;
import com.web.movie.mapper.UserInfoMapper;
import com.web.movie.mapper.UserMapper;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    @Override
    public User loginIn(int id, String password) {
        return userMapper.getInfo(id, password);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public Boolean register(int id, String password, String name) {
        User user = userMapper.getUser(id);
        if (user == null) {
            userMapper.insertUser(id, password);
            UserInfo userInfo=new UserInfo();
            userInfo.setId(id);
            userInfo.setName(name);
            userInfoMapper.insertUserInfo(userInfo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return userInfoMapper.getUserInfoById(id);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }
}

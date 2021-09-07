package com.web.movie.mapper;

import com.web.movie.entity.UserInfo;

public interface UserInfoMapper {

    UserInfo getUserInfoById(int id);

    void insertUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

}

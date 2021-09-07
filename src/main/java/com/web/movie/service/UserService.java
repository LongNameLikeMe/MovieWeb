package com.web.movie.service;

import com.web.movie.entity.User;
import com.web.movie.entity.UserInfo;

public interface UserService {

    User loginIn(int id, String password);

    User getUser(int id);

    Boolean register(int id, String password, String name);

    UserInfo getUserInfoById(int id);

    void updateUserInfo(UserInfo userInfo);

}

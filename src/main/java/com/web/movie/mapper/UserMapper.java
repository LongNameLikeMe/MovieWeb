package com.web.movie.mapper;

import com.web.movie.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

     User getInfo(@Param("id") int id, @Param("password") String password);

     User getUser(@Param("id") int id);

     void insertUser(@Param("id") int id, @Param("password") String password);

}

package com.web.movie.service.impl;

import com.web.movie.entity.UserMovieRating;
import com.web.movie.mapper.UserMovieRatingMapper;
import com.web.movie.service.UserMovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMovieRatingServiceImpl implements UserMovieRatingService {

    @Autowired(required = false)
    private UserMovieRatingMapper userMovieRatingMapper;

    @Override
    public List<UserMovieRating> getUserMovieRatingByUserId(int user_id) {
        return userMovieRatingMapper.getUserMovieRatingByUserId(user_id);
    }
}

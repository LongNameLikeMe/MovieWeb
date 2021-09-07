package com.web.movie.service;

import com.web.movie.entity.UserMovieRating;

import java.util.List;

public interface UserMovieRatingService {

    List<UserMovieRating> getUserMovieRatingByUserId(int user_id);

}

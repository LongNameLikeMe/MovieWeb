package com.web.movie.mapper;

import com.web.movie.entity.UserMovieRating;

import java.util.List;

public interface UserMovieRatingMapper {

    List<UserMovieRating> getCommentIdByMovie(int id);

    List<UserMovieRating> getCommentIdByUser(int id);

    int insertUserMovieRating(UserMovieRating userMovieRating);

    void deleteUserMovieRatingByCommentId(int comment_id);

    List<UserMovieRating> getUserMovieRatingByUserId(int user_id);

}

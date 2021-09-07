package com.web.movie.service;

import com.web.movie.entity.Comment;
import com.web.movie.entity.Rating;
import com.web.movie.entity.UserMovieRating;

import java.util.List;

public interface RatingService {

    int getRatingCount();

    List<Rating> getRatings();

    List<Comment> getRatingByMovie(int id);

    List<Comment> getRatingByUser(int id);

    int insertComment(Rating rating, UserMovieRating userMovieRating);

    void deleteComment(int comment_id);

}

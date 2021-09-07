package com.web.movie.mapper;

import com.web.movie.entity.Rating;

import java.util.List;

public interface RatingMapper {

    int getRatingCount();

    List<Rating> getRatings();

    Rating getRatingById(int id);

    int insertComment(Rating rating);

    void deleteRatingByCommentId(int comment_id);

}

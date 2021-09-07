package com.web.movie.service.impl;

import com.web.movie.entity.Comment;
import com.web.movie.entity.Rating;
import com.web.movie.entity.UserMovieRating;
import com.web.movie.mapper.*;
import com.web.movie.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired(required = false)
    RatingMapper ratingMapper;

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    UserInfoMapper userInfoMapper;

    @Autowired(required = false)
    MovieInfoMapper movieInfoMapper;

    @Autowired(required = false)
    UserMovieRatingMapper userMovieRatingMapper;

    @Override
    public int getRatingCount() {
        return ratingMapper.getRatingCount();
    }

    @Override
    public List<Rating> getRatings() {
        return ratingMapper.getRatings();
    }

    @Override
    public List<Comment> getRatingByMovie(int id) {
        List<UserMovieRating> list=userMovieRatingMapper.getCommentIdByMovie(id);
        List<Comment> result= new ArrayList<>();
        for (UserMovieRating comment : list){
            Rating rating=ratingMapper.getRatingById(comment.getComment_id());
            Comment out=new Comment(rating,comment.getMovie_id(),comment.getUser_id());
            out.setUser_name(userInfoMapper.getUserInfoById(comment.getUser_id()).getName());
            result.add(out);
        }
        return result;
    }

    @Override
    public List<Comment> getRatingByUser(int id) {
        List<UserMovieRating> list=userMovieRatingMapper.getCommentIdByUser(id);
        List<Comment> result= new ArrayList<>();
        for (UserMovieRating comment : list){
            Rating rating=ratingMapper.getRatingById(comment.getComment_id());
            Comment out=new Comment(rating,comment.getMovie_id(),comment.getUser_id());
            out.setMovie_title(movieInfoMapper.getMovieById(comment.getMovie_id()).getTitle());
            result.add(out);
        }
        return result;
    }

    @Override
    public int insertComment(Rating rating, UserMovieRating userMovieRating) {
        ratingMapper.insertComment(rating);
        userMovieRatingMapper.insertUserMovieRating(userMovieRating);
        return 0;
    }

    @Override
    public void deleteComment(int comment_id) {
        userMovieRatingMapper.deleteUserMovieRatingByCommentId(comment_id);
        ratingMapper.deleteRatingByCommentId(comment_id);
    }
}

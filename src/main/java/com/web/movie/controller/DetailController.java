package com.web.movie.controller;

import com.web.movie.entity.Comment;
import com.web.movie.entity.MovieInfo;
import com.web.movie.entity.Rating;
import com.web.movie.entity.UserMovieRating;
import com.web.movie.service.MovieInfoService;
import com.web.movie.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DetailController {

    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    RatingService ratingService;

    @RequestMapping("/detail")
    public String toDetail(int id, ModelMap map, HttpSession session) {
        MovieInfo movie = movieInfoService.getMovieById(id);
        List<Comment> commentList = ratingService.getRatingByMovie(movie.getId());
        System.out.println(commentList.size());
        session.setAttribute("movieId", movie.getId());
        map.addAttribute("movie", movie);
        map.addAttribute("commentList", commentList);
        return "detail";
    }

    @RequestMapping("/submitComment")
    public String toCommend(String content, String score, ModelMap map, HttpSession session) {

        int userId = (int) session.getAttribute("id");
        int movieId = (int) session.getAttribute("movieId");

        int comment_id = ratingService.getRatingCount() + 1;
        if (content==null|| content.equals("")){
            content="该用户没有发表评论";
        }
        Rating rating = new Rating(comment_id, content, null, score);
        UserMovieRating userMovieRating = new UserMovieRating(comment_id, movieId, userId);
        ratingService.insertComment(rating, userMovieRating);

        MovieInfo movie = movieInfoService.getMovieById(movieId);
        map.addAttribute("movie", movie);
        List<Comment> commentList = ratingService.getRatingByMovie(movieId);
        map.addAttribute("commentList", commentList);
        return "detail";
    }

}
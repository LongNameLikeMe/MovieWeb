package com.web.movie.mapper;

import com.web.movie.entity.MovieInfo;
import com.web.movie.entity.MoviePriority;

import java.util.List;

public interface MovieInfoMapper {

    List<MovieInfo> getAllMovies();

    MovieInfo getMovieById(int id);

    List<MovieInfo> getNewMovies();

    List<MovieInfo> getHighScoreMovies();

    List<MovieInfo> getMovieByName(String title);

    List<MoviePriority> getRecommendedMovies(int id);



}

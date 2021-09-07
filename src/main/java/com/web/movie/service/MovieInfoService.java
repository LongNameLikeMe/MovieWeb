package com.web.movie.service;

import com.web.movie.entity.MovieInfo;
import com.web.movie.entity.MoviePriority;

import java.util.List;

public interface MovieInfoService {

    List<MovieInfo> getAllMovies();

    MovieInfo getMovieById(int id);

    List<MovieInfo> getNewMovies();

    List<MovieInfo> getHighScoreMovies();

    List<MovieInfo> getMovieByName(String name);

    List<MovieInfo> getRecommendedMovies(int id);

    int insertMoviePriority(MoviePriority mp);

    void deleteMoviePriority(int id);

}

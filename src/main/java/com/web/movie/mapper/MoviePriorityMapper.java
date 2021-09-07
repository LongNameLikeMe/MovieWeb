package com.web.movie.mapper;

import com.web.movie.entity.MoviePriority;

public interface MoviePriorityMapper {
    int insertMoviePriority(MoviePriority mp);

    void deleteMoviePriority(int id);
}

package com.web.movie.service.impl;

import com.web.movie.entity.MovieInfo;
import com.web.movie.entity.MoviePriority;
import com.web.movie.entity.UserMovieRating;
import com.web.movie.mapper.MovieInfoMapper;
import com.web.movie.mapper.MoviePriorityMapper;
import com.web.movie.mapper.UserMovieRatingMapper;
import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Autowired(required = false)
    private MovieInfoMapper movieInfoMapper;

    @Autowired(required = false)
    private MoviePriorityMapper moviePriorityMapper;

    @Autowired(required = false)
    private UserMovieRatingMapper userMovieRatingMapper;

    @Override
    public List<MovieInfo> getAllMovies() {
        return movieInfoMapper.getAllMovies();
    }

    @Override
    public MovieInfo getMovieById(int id) {
        return movieInfoMapper.getMovieById(id);
    }

    @Override
    public List<MovieInfo> getNewMovies() {
        return movieInfoMapper.getNewMovies();
    }

    @Override
    public List<MovieInfo> getHighScoreMovies() {
        return movieInfoMapper.getHighScoreMovies();
    }

    @Override
    public List<MovieInfo> getMovieByName(String name) {
        return movieInfoMapper.getMovieByName(name);
    }

    @Override
    public int insertMoviePriority(MoviePriority mp) {
        moviePriorityMapper.insertMoviePriority(mp);
        return 0;
    }

    @Override
    public List<MovieInfo> getRecommendedMovies(int id) {
        deleteMoviePriority(id);
        List<UserMovieRating> umr_list = userMovieRatingMapper.getUserMovieRatingByUserId(id);
        List<MovieInfo> rated_movies = new ArrayList<MovieInfo>();
        for (UserMovieRating umr : umr_list) {
            rated_movies.add(movieInfoMapper.getMovieById(umr.getMovie_id()));
        }
        List<MovieInfo> movies = movieInfoMapper.getAllMovies();
        List<MovieInfo> unrated_movies = new ArrayList<MovieInfo>();
        for (MovieInfo movie : movies) {
            int flag = 0;
            for (MovieInfo rated : rated_movies) {
                if (movie.getId() == rated.getId()) flag++;
            }
            if (flag == 0) {
                unrated_movies.add(movie);
            }

        }
        for (MovieInfo unrated : unrated_movies) {

            double priority = 0;
            for (MovieInfo rated : rated_movies) {
                int similarity = calculateSimilarity(rated, unrated);
                double weight = Double.parseDouble(rated.getScore()) - 6;
                priority += (weight * similarity);
            }
            if(!rated_movies.isEmpty()) {
                MoviePriority mp = new MoviePriority(unrated.getId(), id, priority / 2 + Double.parseDouble(unrated.getScore()));
                insertMoviePriority(mp);
            }
            else{
                return getHighScoreMovies();
            }

        }
        List<MoviePriority> list = movieInfoMapper.getRecommendedMovies(id);
        List<MovieInfo> result = new ArrayList<MovieInfo>();
        for (MoviePriority mp : list) {
            result.add(movieInfoMapper.getMovieById(mp.getMovie_id()));
        }
        return result;
    }
    int calculateSimilarity(MovieInfo m1, MovieInfo m2) {
        int similarity = 0;
        //director
        String m1_director = m1.getDirector_name();
        String m2_director = m2.getDirector_name();
        if (m1_director.equals(m2_director))
            similarity += 2;
        //actor
        List<String> m1_actor = new ArrayList<String>();
        m1_actor.add(m1.getActor_1());
        m1_actor.add(m1.getActor_2());
        m1_actor.add(m1.getActor_3());
        List<String> m2_actor = new ArrayList<String>();
        m2_actor.add(m2.getActor_1());
        m2_actor.add(m2.getActor_2());
        m2_actor.add(m2.getActor_3());
        for (String actor1 : m1_actor)
            for (String actor2 : m2_actor) {
                if (actor1.equals(actor2))
                    similarity += 3;
            }
        //genre
        StringTokenizer st1 = new StringTokenizer(m1.getGenres(), "|");
        StringTokenizer st2 = new StringTokenizer(m2.getGenres(), "|");
        List<String> m1_genres = new ArrayList<String>();
        while (st1.hasMoreTokens())
            m1_genres.add(st1.nextToken());
        List<String> m2_genres = new ArrayList<String>();
        while (st2.hasMoreTokens())
            m2_genres.add(st2.nextToken());
        for (String genre1 : m1_genres)
            for (String genre2 : m2_genres) {
                if (genre1.equals(genre2))
                    similarity += 3;
            }
        //keyword
        st1 = new StringTokenizer(m1.getPlot_keywords(), "|");
        st2 = new StringTokenizer(m2.getPlot_keywords(), "|");
        List<String> m1_keywords = new ArrayList<String>();
        while (st1.hasMoreTokens())
            m1_keywords.add(st1.nextToken());
        List<String> m2_keywords = new ArrayList<String>();
        while (st2.hasMoreTokens())
            m2_keywords.add(st2.nextToken());
        for (String keyword1 : m1_keywords)
            for (String keyword2 : m2_keywords) {
                if (keyword1.equals(keyword2))
                    similarity += 7;
            }
        return similarity;
    }

    @Override
    public void deleteMoviePriority(int id) {
        moviePriorityMapper.deleteMoviePriority(id);
    }
}

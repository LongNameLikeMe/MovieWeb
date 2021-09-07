package com.web.movie.entity;

import javax.print.DocFlavor;

public class MovieInfo {
    int id;
    String title;
    String director_name;
    String actor_1;
    String actor_2;
    String actor_3;
    String genres;
    String plot_keywords;
    String language;
    String postor;
    String country;
    String content_rating;
    String year;
    String score;
    String num_score;
    String gross;
    String duration;

    public MovieInfo() {
    }

    public MovieInfo(int id, String title, String director_name, String genres,String country) {
        this.id = id;
        this.title = title;
        this.director_name = director_name;
        this.genres=genres;
        this.country=country;
    }

    public MovieInfo(
            int id,
            String title,
            String director_name,
            String actor_1,
            String actor_2,
            String actor_3,
            String genres,
            String plot_keywords,
            String language,
            String postor,
            String country,
            String content_rating,
            String year,
            String score,
            String num_score,
            String gross,
            String duration) {
        this.id = id;
        this.title = title;
        this.director_name = director_name;
        this.actor_1 = actor_1;
        this.actor_2 = actor_2;
        this.actor_3 = actor_3;
        this.genres = genres;
        this.plot_keywords = plot_keywords;
        this.postor = postor;
        this.language = language;
        this.country = country;
        this.content_rating = content_rating;
        this.year = year;
        this.score = score;
        this.num_score = num_score;
        this.gross = gross;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getActor_1() {
        return actor_1;
    }

    public void setActor_1(String actor_1) {
        this.actor_1 = actor_1;
    }

    public String getActor_2() {
        return actor_2;
    }

    public void setActor_2(String actor_2) {
        this.actor_2 = actor_2;
    }

    public String getActor_3() {
        return actor_3;
    }

    public void setActor_3(String actor_3) {
        this.actor_3 = actor_3;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getPlot_keywords() {
        return plot_keywords;
    }

    public void setPlot_keywords(String plot_keywords) {
        this.plot_keywords = plot_keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPostor() {
        return postor;
    }

    public void setPostor(String postor) {
        this.postor = postor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContent_rating() {
        return content_rating;
    }

    public void setContent_rating(String content_rating) {
        this.content_rating = content_rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getNum_score() {
        return num_score;
    }

    public void setNum_score(String num_score) {
        this.num_score = num_score;
    }

    @Override
    public String toString() {
        return "MovieInfo{" + "id=" + id;
    }
}


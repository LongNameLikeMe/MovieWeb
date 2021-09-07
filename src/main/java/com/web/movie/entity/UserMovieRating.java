package com.web.movie.entity;

public class UserMovieRating {
    int comment_id;
    int movie_id;
    int user_id;

    public UserMovieRating() {
    }

    public UserMovieRating(int comment_id, int movie_id, int user_id) {
        this.comment_id = comment_id;
        this.movie_id = movie_id;
        this.user_id = user_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "UserMovieRating{" +
                "comment_id=" + comment_id +
                ", movie_id=" + movie_id +
                ", user_id=" + user_id +
                '}';
    }
}

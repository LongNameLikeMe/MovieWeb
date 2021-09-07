package com.web.movie.entity;

public class Comment {

    int comment_id;
    int movie_id;
    int user_id;
    String content;
    String time;
    String rating;
    String user_name;
    String movie_title;

    public Comment() {
    }

    public Comment(int comment_id, int movie_id, int user_id, String content, String time, String rating) {
        this.comment_id = comment_id;
        this.movie_id = movie_id;
        this.user_id = user_id;
        this.content = content;
        this.time = time;
        this.rating = rating;
    }

    public Comment(Rating rating, int movie_id, int user_id) {
        this.comment_id = rating.comment_id;
        this.content = rating.content;
        this.time = rating.time;
        this.rating = rating.rating;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", movie_id=" + movie_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}

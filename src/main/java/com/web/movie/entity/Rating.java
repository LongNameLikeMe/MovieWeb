package com.web.movie.entity;

public class Rating {
    int comment_id;
    String content;
    String time;
    String rating;

    public Rating() {
    }

    public Rating(int comment_id, String content, String time, String rating) {
        this.comment_id = comment_id;
        this.content = content;
        this.time = time;
        this.rating = rating;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

}

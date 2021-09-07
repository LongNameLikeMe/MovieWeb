package com.web.movie.entity;

public class MoviePriority {
    int movie_id;
    int user_id;
    double priority;

    public MoviePriority(){
    }
    public MoviePriority(int movie_id,int user_id,double priority){
        this.movie_id=movie_id;
        this.user_id=user_id;
        this.priority=priority;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getPriority() {
        return priority;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setPriority(double priority){
        this.priority=priority;
    }
}
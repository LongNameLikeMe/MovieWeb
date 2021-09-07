package com.web.movie.entity;

public class MovieSimilarity {
    int movie1_id;
    int movie2_id;
    String similarity;

    public MovieSimilarity() {
    }

    public MovieSimilarity(int movie1_id, int movie2_id, String similarity) {
        this.movie1_id = movie1_id;
        this.movie2_id = movie2_id;
        this.similarity = similarity;
    }

    public int getMovie1_id() {
        return movie1_id;
    }

    public void setMovie1_id(int movie1_id) {
        this.movie1_id = movie1_id;
    }

    public int getMovie2_id() {
        return movie2_id;
    }

    public void setMovie2_id(int movie2_id) {
        this.movie2_id = movie2_id;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}

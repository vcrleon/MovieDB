package com.example.c4q.moviedb.model;

import java.util.List;

import nl.qbusict.cupboard.annotation.Ignore;

/**
 * Created by jervon.arnoldd on 1/31/18.
 */

public class Results {

    public Long _id;

    private Integer vote_count;
    private Integer id;
    private boolean video;
    private double vote_average;
    private String title;

    private double popularity;
    private String poster_path;
    private String original_language;
    private String original_title;


    private String backdrop_path;
    @Ignore
    private boolean adult;
    private String overview;
    private String release_date;

    public Results() {
        this._id = _id;
        this.vote_count = vote_count;
        this.id = id;
        this.video = video;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
    }

    public Long getId() {
        return _id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public int get_result_Id() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }



    public String getBackdrop_path() {
        return backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }
}

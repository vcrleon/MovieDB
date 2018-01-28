package com.example.c4q.moviedb.model;

import java.util.List;

/**
 * Created by c4q on 1/28/18.
 */

public class UpcomingMovie {
    private List<Results> results;
    private int page;
    private int total_results;
    private Dates dates;
    private int total_pages;

    public List<Results> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public Dates getDates() {
        return dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }
}

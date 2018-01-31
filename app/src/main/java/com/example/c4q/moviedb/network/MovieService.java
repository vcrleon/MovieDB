package com.example.c4q.moviedb.network;

import com.example.c4q.moviedb.model.UpcomingMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by c4q on 1/28/18.
 */

public interface MovieService {
    final String KEY = "27d1d0e0608d5ae056e5e50ab087b24d";

    @GET("movie/upcoming?api_key=" + KEY)
    Call<UpcomingMovie> getUpcomingMovie(@Query("page") int page);


}

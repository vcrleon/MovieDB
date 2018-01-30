package com.example.c4q.moviedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.c4q.moviedb.model.UpcomingMovie;
import com.example.c4q.moviedb.network.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "https://api.themoviedb.org/3/";
    Retrofit retrofit;
    MovieService movieService;
    List<UpcomingMovie> upMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        upMovieList = new ArrayList<>();
        connectApi();
    }

    public void connectApi() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        movieService = retrofit.create(MovieService.class);

        callUpcomingMovie();


    }

    public void callUpcomingMovie() {
        Call<UpcomingMovie> upMovieCall = movieService.getUpcomingMovie(1);
        upMovieCall.enqueue(new Callback<UpcomingMovie>() {
            @Override
            public void onResponse(Call<UpcomingMovie> call, Response<UpcomingMovie> response) {
                Log.d("Movie title: ", response.body().getResults().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<UpcomingMovie> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}

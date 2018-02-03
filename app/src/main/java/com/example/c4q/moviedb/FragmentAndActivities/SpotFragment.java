package com.example.c4q.moviedb.FragmentAndActivities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c4q.moviedb.MainActivity;
import com.example.c4q.moviedb.R;
import com.example.c4q.moviedb.model.Results;
import com.example.c4q.moviedb.model.UpcomingMovie;
import com.example.c4q.moviedb.network.MovieService;
import com.example.c4q.moviedb.views.MovieAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpotFragment extends Fragment {
    View v;


    public SpotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_spot, container, false);

        connectApi();







        return v;
    }

    public void connectApi() {
    }

//    public void callUpcomingMovie() {
//        Call<UpcomingMovie> upMovieCall = movieService.getUpcomingMovie(1);
//        Log.e("url",upMovieCall.request().url().toString());
//        upMovieCall.enqueue(new Callback<UpcomingMovie>() {
//            @Override
//            public void onResponse(Call<UpcomingMovie> call, Response<UpcomingMovie> response) {
//                List<Results> results = response.body().getResults();
//
//
////                for (int i = 0; i < results.size(); i++) {
////                    Log.e("onResponse: ", results.get(i).getTitle());
//////                    cupboard().withDatabase(db).put(results.get(i));
////                }
//                adapter = new MovieAdapter(results);
//                movieRV.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<UpcomingMovie> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//    }



}



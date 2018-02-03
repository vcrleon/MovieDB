package com.example.c4q.moviedb.FragmentAndActivities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.moviedb.R;

import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class Movieragment extends Fragment {

View v;
    public Movieragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_movieragment, container, false);







        return v;
    }

}

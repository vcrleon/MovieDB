package com.example.c4q.moviedb.network;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.moviedb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheaterFragment extends Fragment {

    View v;

    public TheaterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_theater, container, false);
        return v;
    }

}

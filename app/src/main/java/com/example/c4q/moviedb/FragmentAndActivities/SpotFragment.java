package com.example.c4q.moviedb.FragmentAndActivities;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c4q.moviedb.R;


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

        return v;
    }

}

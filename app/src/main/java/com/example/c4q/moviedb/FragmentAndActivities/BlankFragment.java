package com.example.c4q.moviedb.FragmentAndActivities;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c4q.moviedb.R;
import com.example.c4q.moviedb.network.TheaterFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    View v;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v =inflater.inflate(R.layout.fragment_blank, container, false);
        NavigationView nav = v.findViewById(R.id.vNavigation);
        nav.setBackgroundColor(Color.TRANSPARENT);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.spot:
                        SpotFragment spotFrag = new SpotFragment();
                        FragmentManager manager = ((FragmentActivity)getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.content, spotFrag);
                        transaction.commit();
                        return true;
                    case R.id.movies:
                        Movieragment movieFrahment = new Movieragment();
                        FragmentManager manager2 = ((FragmentActivity)getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction2 = manager2.beginTransaction();
                        transaction2.replace(R.id.content, movieFrahment);
                        transaction2.commit();
                        return true;
                    case R.id.theater:
                        TheaterFragment frag = new TheaterFragment();
                        FragmentManager manager3 = ((FragmentActivity)getContext()).getSupportFragmentManager();
                        FragmentTransaction transaction3 = manager3.beginTransaction();
                        transaction3.replace(R.id.content, frag);
                        transaction3.commit();
                        return true;
                }
                Toast.makeText(getActivity(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return v;
    }

}

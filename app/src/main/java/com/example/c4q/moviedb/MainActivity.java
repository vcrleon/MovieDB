package com.example.c4q.moviedb;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.c4q.moviedb.FragmentAndActivities.MenuFrag;
import com.example.c4q.moviedb.FragmentAndActivities.SearchActivity;
import com.example.c4q.moviedb.data.base.MovieDataBase;
import com.example.c4q.moviedb.model.Results;
import com.example.c4q.moviedb.views.MovieAdapter;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.example.c4q.moviedb.model.UpcomingMovie;
import com.example.c4q.moviedb.network.MovieService;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MainActivity extends AppCompatActivity {


    private FlowingDrawer mDrawer;
    private final String BASE_URL = "https://api.themoviedb.org/3/";
    Retrofit retrofit;
    MovieService movieService;
    List<UpcomingMovie> upMovieList;
    List<Results> movies;
    static SQLiteDatabase db;
    MovieDataBase helper;
    RecyclerView movieRV;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectAll();
        movies = new ArrayList<>();
        movieRV = findViewById(R.id.rvFeed);

        GridLayoutManager grid = new GridLayoutManager(getApplicationContext(), 3);
        movieRV.setLayoutManager(grid);
        connectApi();


        helper = new MovieDataBase(this);
        db = helper.getWritableDatabase();

        selectAll();

        mDrawer = findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);

        navfill();


        upMovieList = new ArrayList<>();

        setupToolbar();

//        getAllResults(cupboard().withDatabase(db).query(Results.class).query());
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.headline);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawer.toggleMenu();
            }
        });
    }

    private void navfill() {
        FragmentManager fm = getSupportFragmentManager();
        MenuFrag mMenuFragment = (MenuFrag) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuFrag();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
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
                List<Results> results = response.body().getResults();
                Log.e("result size", results.size() + "");
                for (int i = 0; i < results.size(); i++) {
                    if (!movies.contains(results.get(i))) {
//                    Log.e("onResponse: ", results.get(i).getTitle());
                    cupboard().withDatabase(db).put(results.get(i));
                    }
                }
                adapter = new MovieAdapter(results);
                movieRV.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UpcomingMovie> call, Throwable t) {
                Log.e("Failed,", t.getLocalizedMessage());
            }
        });
    }

    private void selectAll() {
        try {
            QueryResultIterable<Results> itr = cupboard().withDatabase(db).query(Results.class).query();
            for (Results m : itr) {
                if (!movies.contains(m)) {
                    movies.add(m);
                } else {
                }
            }
            itr.close();
        } catch (Exception e) {
            Log.e("selectAllCats: ", e.toString());
        }
//        adapter = new MovieAdapter(movies);
//        movieRV.setAdapter(adapter);

//        Log.e("selectAllResults ", String.valueOf(movies.size()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Results> getAllResults(QueryResultIterable<Results> b) {
        final List<Results> resultsList = new ArrayList<>();
        for (Results a : b) {
            resultsList.add(a);
        }
        return resultsList;
    }
}

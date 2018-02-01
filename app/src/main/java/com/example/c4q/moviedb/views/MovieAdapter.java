package com.example.c4q.moviedb.views;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.moviedb.R;
import com.example.c4q.moviedb.model.Results;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by c4q on 1/31/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Results> movieList;


    public MovieAdapter(List<Results> movieList) {
        this.movieList = movieList;
    }
    public MovieAdapter() {

    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_itemview, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Results results = movieList.get(position);

        holder.onBind(results);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView movieImage;
        private TextView movieTitle;


        public MovieViewHolder(View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
        }

        public void onBind(Results results) {
            Picasso.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500" + results.getPoster_path())
                    .into(movieImage);
            movieTitle.setText(results.getTitle());
        }
    }
}
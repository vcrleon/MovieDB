package com.example.c4q.moviedb.FragmentAndActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.moviedb.R;
import com.example.c4q.moviedb.model.Results;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    ImageView picture;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        picture = findViewById(R.id.picture);
        title = findViewById(R.id.title);

        String data = getIntent().getStringExtra("Results");
        Gson gson = new Gson();
        Results results = gson.fromJson(data, Results.class);

        Picasso.with(this)
                .load("https://image.tmdb.org/t/p/w500" + results.getPoster_path())
                .into(picture);

        title.setText(results.getTitle());

    }

}

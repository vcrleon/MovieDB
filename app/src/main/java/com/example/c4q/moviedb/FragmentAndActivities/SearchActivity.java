package com.example.c4q.moviedb.FragmentAndActivities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.c4q.moviedb.MainActivity;
import com.example.c4q.moviedb.R;
import com.example.c4q.moviedb.data.base.MovieDataBase;
import com.example.c4q.moviedb.model.Results;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView text;
    private EditText mEditWordView;
    private SQLiteDatabase db;
    private SQLiteDatabase read;
    String word;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);

        mEditWordView = findViewById(R.id.edit);
        text = findViewById(R.id.search_result);
        MovieDataBase helper = MovieDataBase.getInstance(this);
        db = helper.getWritableDatabase();
        read=helper.getReadableDatabase();
    }

    public void showResult(View view) {
        word = mEditWordView.getText().toString();
        String selectionString = "title='coco'";
        QueryResultIterable<Results> iterable = cupboard()
                .withDatabase(db)
                .query(Results.class)
                .withSelection(selectionString)
                .query();
        List<Results> list = getListFromQueryResultIterator(iterable);
        Log.e("Size",list.size()+"");
    }


    private List<Results> getListFromQueryResultIterator(QueryResultIterable<Results> b) {
        final List<Results> resultsList = new ArrayList<>();
        for (Results a : b) {
            resultsList.add(a);
        }
        return resultsList;
    }

}

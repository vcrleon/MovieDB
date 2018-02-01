package com.example.c4q.moviedb.data.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.c4q.moviedb.model.Results;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by jervon.arnoldd on 1/31/18.
 */

public class MovieDataBase extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "fellows";
    private static final String DATABASE_NAME = "movie.db";
    private static final int DATABASE_VERSION = 1;
    private static MovieDataBase instance;


    public static synchronized MovieDataBase getInstance(Context context) {
        if (instance == null) {
            instance = new MovieDataBase(context.getApplicationContext());
        }
        return instance;
    }


    public MovieDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Results.class);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       cupboard().withDatabase(db).upgradeTables();
    }


}

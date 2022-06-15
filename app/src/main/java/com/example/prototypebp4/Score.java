package com.example.prototypebp4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototypebp4.database.databasehelper;

public class Score extends AppCompatActivity {


    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        databasehelper dbHelper = new databasehelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from GebruikerResultaatGeslachtScore";
        Cursor cur_scorehistory = db.rawQuery(sql,null);
        ContentValues valuesname = new ContentValues();

    }
}
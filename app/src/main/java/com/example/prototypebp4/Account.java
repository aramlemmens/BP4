package com.example.prototypebp4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototypebp4.database.databasehelper;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        databasehelper dbHelper = new databasehelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from gebruikergewichtgeslachtargument";

        Cursor cur_account = db.rawQuery(sql,null);
        System.out.println(sql);

    }
}
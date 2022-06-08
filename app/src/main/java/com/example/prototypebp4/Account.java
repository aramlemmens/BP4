package com.example.prototypebp4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.prototypebp4.database.databasehelper;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        databasehelper dbHelper = new databasehelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select f._id, f.titel, f.jaar, f.regisseur, r.naam, r.geboortedatum, " +
                "f.categorie, c.omschrijving catomschrijving, f.genre, g.omschrijving genomschrijving " +
                "from films f join regisseurs r on (f.regisseur = r._id) " +
                "join categorieen c on (f.categorie = c._id) " +
                "join genres g on (f.genre = g._id)";

    }
}
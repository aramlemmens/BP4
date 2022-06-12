package com.example.prototypebp4;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototypebp4.database.DataTables;
import com.example.prototypebp4.database.databasehelper;

public class MainActivity extends AppCompatActivity {
    private databasehelper dbHelper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnToevoegen = findViewById(R.id.button_next);
        btnToevoegen.setOnClickListener(v -> {
            EditText inputname = findViewById(R.id.editTextTextPersonName6);
            EditText inputweight = findViewById(R.id.editTextTextPersonName7);
            EditText inputargument = findViewById(R.id.editTextTextPersonName8);

            String newGebruiker = inputname.getText().toString();
            String newGewicht = inputweight.getText().toString();
            String newargument = inputargument.getText().toString();


            SQLiteDatabase db = dbHelper.getReadableDatabase();

            String sqln = "select max(gebruiker) from Gebruikers";
            String sqlw = "select max(gewicht) from Gewichten";
            String sqla = "select max(argument) from Argumenten";

            Cursor cur_idn = db.rawQuery(sqln, null);
            ContentValues valuesname = new ContentValues();
            ContentValues values = new ContentValues();


            valuesname.put(DataTables.Gebruikers.COLUMN_NAME_GEBRUIKER, newGebruiker);
            long resultn = db.insert(DataTables.Gebruikers.TABLE_NAME, null,valuesname);
            inputname.setText("");

            Cursor cur_idw = db.rawQuery(sqlw, null);
            ContentValues valuesweight = new ContentValues();
            valuesweight.put(DataTables.Gewichten.COLUMN_NAME_GEWICHT, Integer.parseInt(newGewicht));
            long resultw = db.insert(DataTables.Gewichten.TABLE_NAME, null,valuesweight);

            Cursor cur_ida = db.rawQuery(sqla, null);
            ContentValues valuearg = new ContentValues();
            valuearg.put(DataTables.Argumenten.COLUMN_NAME_ARGUMENT, newargument);
            long resulta = db.insert(DataTables.Argumenten.TABLE_NAME, null,valuearg);

            ContentValues value = new ContentValues();
            value.put(DataTables.GebruikerGewichtGeslachtArgument.COLUMN_NAME_GEBRUIKER, newGebruiker);
            value.put(DataTables.GebruikerGewichtGeslachtArgument.COLUMN_NAME_GEWICHT, newGewicht);
            value.put(DataTables.GebruikerGewichtGeslachtArgument.COLUMN_NAME_ARGUMENT, newargument);

            db.insert(DataTables.GebruikerGewichtGeslachtArgument.TABLE_NAME,null,value);
            inputname.setText("");
            inputweight.setText("");
            inputargument.setText("");


            Intent i = new Intent(v.getContext(), Menu.class);
            startActivity(i);
            });
    }
}
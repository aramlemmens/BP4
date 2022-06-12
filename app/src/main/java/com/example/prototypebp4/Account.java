package com.example.prototypebp4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototypebp4.database.databasehelper;
import com.example.prototypebp4.model.account_model;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        databasehelper dbHelper = new databasehelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from gebruikergewichtgeslachtargument";
        account_model ac = new account_model();



        Cursor cur_account = db.rawQuery(sql,null);
        if (cur_account.moveToLast()){
            do {
                ac.setGebruiker(cur_account.getString(0));
                ac.setGewicht(cur_account.getInt(1));
//                ac.setGeslacht(cur_account.getString(2));
                ac.setArgument(cur_account.getString(3));
            }while (false);
        }

        TextView tvname = findViewById(R.id.textViewName);
        tvname.setText(ac.getGebruiker());

        TextView tvgewicht = findViewById(R.id.textViewGewicht);
        tvgewicht.setText(String.valueOf(ac.getGewicht()));

        TextView tvargument = findViewById(R.id.textViewArgument);
        tvargument.setText(ac.getArgument());

    }
}
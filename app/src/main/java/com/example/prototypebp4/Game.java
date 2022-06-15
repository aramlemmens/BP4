package com.example.prototypebp4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prototypebp4.database.DataTables;
import com.example.prototypebp4.database.databasehelper;
import com.example.prototypebp4.model.account_model;
import com.example.prototypebp4.model.scorehistory_model;

public class Game extends AppCompatActivity {
    scorehistory_model sh_m = new scorehistory_model();
    account_model a_m = new account_model();

    public int counter = 0;
    public int score = 0;
    public int time = 0;
    private boolean startend = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        databasehelper dbHelper = new databasehelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from gebruikergewichtgeslachtargument";
        Cursor cur_account = db.rawQuery(sql,null);
        if (cur_account.moveToLast()){
            do {
                a_m.setGebruiker(cur_account.getString(0));
            }while (false);
        }

        final TextView textendstart = findViewById(R.id.textView10);
        final TextView finishstart = findViewById(R.id.button2);
//        final TextView counttime=findViewById(R.id.textView8);

        Spinner spinnerlevels = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerlevels.setAdapter(adapter);

//        int spinnernum = spinnertext.indexOf(" ");
//        String test = spinnertext.substring(spinnernum);
//        int inttest = Integer.parseInt(test);

        Button scoreadd = findViewById(R.id.button2);
        scoreadd.setOnClickListener(v -> {
            if(startend == true) {
                textendstart.setText(R.string.textview_End);
                finishstart.setText(R.string.textview_Finish);
                startend = false;

            }
            else if(startend == false){
                String spinnertext = spinnerlevels.getSelectedItem().toString();
                startend = true;
                sh_m.setScore(score);
                sh_m.setGebruiker(a_m.getGebruiker());
                sh_m.setLevel(spinnertext);
//                TextView scoretext = findViewById(R.id.textView9);
//                scoretext.setText(String.valueOf(score));
                textendstart.setText(R.string.textview_statuitleg);
                finishstart.setText(R.string.textview_startbtn);



            String sqln = "select max(gebruiker) from Gebruikers";
            String sqlr = "select max(resultaat) from Resultaaten";

            Cursor cur_idn = db.rawQuery(sqln, null);
            ContentValues valuesname = new ContentValues();
            ContentValues values = new ContentValues();

            Cursor cur_idr = db.rawQuery(sqlr, null);
            ContentValues valuearg = new ContentValues();
            valuearg.put(DataTables.Argumenten.COLUMN_NAME_ARGUMENT, sh_m.getLevel());
            long resulta = db.insert(DataTables.Argumenten.TABLE_NAME, null,valuearg);

            ContentValues value = new ContentValues();
            value.put(DataTables.GebruikerResultaatGeslachtScore.COLUMN_NAME_GEBRUIKER, sh_m.getGebruiker());
            value.put(DataTables.GebruikerResultaatGeslachtScore.COLUMN_NAME_RESULTAAT, sh_m.getLevel());

            db.insert(DataTables.GebruikerResultaatGeslachtScore.TABLE_NAME,null,value);
            }
        });
    }

}
package com.example.prototypebp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton togamestart = findViewById(R.id.imageButtonGame);
        togamestart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), GameStart.class);
                startActivity(i);
            }
        });

        ImageButton toscorehistory = findViewById(R.id.imageButtonScoreHistory);
        toscorehistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), GameStart.class);
                startActivity(i);
            }
        });

        ImageButton topersonelaccount = findViewById(R.id.imageButtonAccount);
        topersonelaccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), GameStart.class);
                startActivity(i);
            }
        });
    }
}
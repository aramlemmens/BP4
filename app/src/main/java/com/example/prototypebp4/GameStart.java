package com.example.prototypebp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GameStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        ImageButton alleen = findViewById(R.id.imageButton_alleen);
        alleen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(),Game.class);
                startActivity(i);
            }
        });

        ImageButton samen = findViewById(R.id.imageButton2_samen);
        samen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(),Game.class);
                startActivity(i);
            }
        });

    }
}
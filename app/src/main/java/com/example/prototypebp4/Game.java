package com.example.prototypebp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.prototypebp4.model.scorehistory_model;

import java.util.Timer;

public class Game extends AppCompatActivity {

    scorehistory_model sh_m = new scorehistory_model();

    public int counter = 0;
    public int score = 0;
    public int rv = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final TextView counttime=findViewById(R.id.textView8);
        final TextView reactievermogentext = findViewById(R.id.textView10);

        new CountDownTimer(100000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(counter));
                counter++;
                int counterinmin = counter / 60;
                if (score != 0 && counterinmin != 0) {
                    rv = score / counterinmin;
                    reactievermogentext.setText(rv + " score per minuut");
                }
                else reactievermogentext.setText("0 score per minuut");

            }
            @Override
            public void onFinish() {
                counttime.setText("Finished");
                sh_m.setScore(score);
                sh_m.setGebruiker(g);
                sh_m.setReactievermogen(rv);
            }
        }.start();

        Button scoreadd = findViewById(R.id.button2);
        scoreadd.setOnClickListener(v -> {
            if(score == 0){
                score++;
                score = score * 100;
            }
            else score = score + 100;
            TextView scoretext = findViewById(R.id.textView9);
            scoretext.setText(String.valueOf(score));
        });
    }
}
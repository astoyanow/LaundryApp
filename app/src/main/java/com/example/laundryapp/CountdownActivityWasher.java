package com.example.laundryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class CountdownActivityWasher extends AppCompatActivity {

    private TextView countdownTime;
    private Button startStop;
    CountdownTimer stopwatch = new CountdownTimer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        startStop = findViewById(R.id.startPauseButton);
        countdownTime = findViewById(R.id.timeLeft);

        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopwatch.pauseResume(countdownTime);
            }
        });


    }


    }


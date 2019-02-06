package com.example.laundryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountdownActivityDryer extends AppCompatActivity {

    private TextView countdownTime;
    private Button startStop;
    CountdownTimer dryerStopwatch = new CountdownTimer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_dryer);

        startStop = findViewById(R.id.startPauseButton);
        countdownTime = findViewById(R.id.timeLeft);

        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dryerStopwatch.pauseResume(countdownTime);
            }
        });


    }
}

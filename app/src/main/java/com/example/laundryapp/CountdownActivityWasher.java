package com.example.laundryapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class CountdownActivityWasher extends AppCompatActivity {
    private TextView countdownTime;
    private Button pauseAndResume;
    private CountDownTimer timer;
    private boolean isCounting;
    private long timeLeft = 1620000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        pauseAndResume = findViewById(R.id.startPauseButton);
        countdownTime = findViewById(R.id.timeLeft);

        pauseAndResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseResume();
            }
        });
        updateTimeLeft();
    }

    public void pauseResume(){
        if (isCounting == true){
            pause();
        }
        else{
            countingDown();
        }
    }

    public void countingDown(){
        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTimeLeft();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        isCounting = true;
        pauseAndResume.setText("Pause");
    }

    public void pause(){
        timer.cancel();
        isCounting = false;
        pauseAndResume.setText("Resume");
    }

    public void updateTimeLeft(){
        int minutes = (int) timeLeft/6000;
        int seconds = (int) timeLeft % 6000 / 1000;
        String remainingTime;
        remainingTime = minutes + ":";
        if (seconds < 10){
            remainingTime += "0" + seconds;
        }
        remainingTime += seconds;

        countdownTime.setText(remainingTime);
    }
}

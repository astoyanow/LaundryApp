package com.example.laundryapp;

import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Button;


public class CountdownTimer {

    private CountDownTimer timer;
    private long timeLeft = 1620000; //retrieve from save file or editText
    public boolean isRunning;


    public void pauseResume(TextView displayedTimeLeft, Button startButton){
        if (isRunning == true){
            pause();
            startButton.setText("Start");
        }
        else{
            countingDown(displayedTimeLeft);
            startButton.setText("Pause");
        }
    }

    //parse or get number from user input in WasherAndDryerSettings activity

    public void countingDown(final TextView displayedTimeLeft){
        isRunning = true;
        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                displayedTimeLeft.setText(updateTimeLeft());
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void pause(){
        isRunning = false;
        timer.cancel();

    }
    public String updateTimeLeft(){
        int minutes = (int) timeLeft/60000;
        int seconds = (int) timeLeft % 60000 / 1000;
        String remainingTime;
        remainingTime = minutes + ":";
        if (seconds < 10){
           remainingTime += "0";
       }
        remainingTime += seconds;
        return remainingTime;
    }
}

package com.example.laundryapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Button;


public class CountdownTimer extends MainActivity {

    private CountDownTimer timer;
    public boolean isRunning;
    public int timeLeft = 1620000;
    //Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    //MediaPlayer mp = MediaPlayer.create(MainActivity.class, notification);


    public void changeTimerDuration(int minutes, int seconds) {
        timeLeft = ChangeTimes.changeToMillis(minutes) + seconds * 1000;
    }


    public int getTimeLeft(TextView time) {
        String newTime = time.getText().toString();
        int newIntTime = ChangeTimes.getInputtedTime(newTime);
        return newIntTime;
    }


    public void pauseResume(TextView displayedTimeLeft, Button startButton){
        if (isRunning == true){
            pause();
            startButton.setText("Start");
        }
        else{
            countingDown(displayedTimeLeft);
            startButton.setText("Pause");
        }
        if (displayedTimeLeft.getText().toString() == "0:00"){
            startButton.setText("Start");
        }
    }


    public void countingDown(final TextView displayedTimeLeft){
        isRunning = true;
        timeLeft = getTimeLeft(displayedTimeLeft);
        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = (int)millisUntilFinished;
                displayedTimeLeft.setText(updateTimeLeft());
            }

            @Override
            public void onFinish() {
                //mp.start();
            }
        }.start();
    }


    public void pause(){
        isRunning = false;
        timer.cancel();
    }

    public void stop(TextView time, Button button){
        isRunning = false;
        timer.cancel();
        time.setText("0:00");
        button.setText("Start");
    }


    public String updateTimeLeft(){
        int minutes = timeLeft/60000;
        int seconds = timeLeft % 60000 / 1000;
        String remainingTime;
        remainingTime = minutes + ":";
        if (seconds < 10){
           remainingTime += "0";
       }
       if (seconds == 1 && minutes == 0){
           seconds --;
       }
        remainingTime += seconds;
        return remainingTime;
    }


}

package com.example.laundryapp;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.NumberPicker;


public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    private static TextView washerTimeText;
    private static TextView dryerTimeText;
    private Button startWashTimer;
    private Button startDryerTimer;
    private Button setWashTime;
    private Button setDryerTime;
    private Button stopWasher;
    private Button stopDryer;
    public NumberPicker washTimes;
    public NumberPicker dryTimes;

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("value is", "" + newVal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        washerTimeText = findViewById(R.id.washerTime);
        dryerTimeText = findViewById(R.id.dryerTime);
        setWashTime = findViewById(R.id.setWashTime);
        setDryerTime = findViewById(R.id.setDryerTime);
        stopWasher = findViewById(R.id.stopWasher);
        stopDryer = findViewById(R.id.stopDryer);
        washTimes = findViewById(R.id.washTimes);
        dryTimes = findViewById(R.id.dryTimes);
        startWashTimer = findViewById(R.id.startWashTimer);
        startDryerTimer = findViewById(R.id.startDryerTimer);
        washTimes.setValue(1);
        dryTimes.setValue(1);
        final CountdownTimer washTimer = new CountdownTimer();
        final CountdownTimer dryTimer = new CountdownTimer();



        setWashTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimer(washTimes, setWashTime, washerTimeText, washTimer, startWashTimer);
            }
        });

        setDryerTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimer(dryTimes, setDryerTime, dryerTimeText, dryTimer, startDryerTimer);
            }
        });

        startWashTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NullPointerException{
                washTimer.pauseResume(washerTimeText, startWashTimer);
            }
        });

        startDryerTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) throws NullPointerException{
                dryTimer.pauseResume(dryerTimeText, startDryerTimer);
            }
        });

        stopWasher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                washTimer.stop(washerTimeText, startWashTimer);
            }
        });

        stopDryer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dryTimer.stop(dryerTimeText, startDryerTimer);
            }
        });

        if (washerTimeText.getText().toString() == "0:00" || dryerTimeText.getText().toString() == "0:00"){
        }


    }

        public void setTimer(final NumberPicker timePicker, Button set, final TextView timer, final CountdownTimer countdown, final Button start) {
            timePicker.setMinValue(1);
            timePicker.setMaxValue(60);
            timePicker.setWrapSelectorWheel(true);
            timePicker.setOnValueChangedListener(this);
            set.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (countdown.isRunning == true) {
                        countdown.stop(timer, start);
                    } else {
                        timer.setText(String.valueOf(timePicker.getValue()) + ":00");
                    }
                }
            });


        }

}

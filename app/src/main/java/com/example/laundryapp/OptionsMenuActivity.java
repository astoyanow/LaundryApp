package com.example.laundryapp;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsMenuActivity extends AppCompatActivity {

    private Button times;
    private Button alarmOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        times = findViewById(R.id.washerDryerTimes);
        alarmOptions = findViewById(R.id.alarmSettings);

        alarmOptions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent setAlarm = new Intent(OptionsMenuActivity.this, AlarmSettingsActivity.class);
                startActivity(setAlarm);
            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setLaundryTimes = new Intent(OptionsMenuActivity.this, WasherAndDryerSettings.class);
                startActivity(setLaundryTimes);
            }
        });

    }
}

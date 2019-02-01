package com.example.laundryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class OptionsMenuActivity extends AppCompatActivity {

    private Button times;
    private Button alarmOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        times = findViewById(R.id.washerDryerTimes);
        alarmOptions = findViewById(R.id.alarmSettings);

    }
}

package com.example.laundryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AlarmSettingsActivity extends AppCompatActivity {

//    Spinner alarmChoices = (Spinner) findViewById(R.id.alarmOptions);
    //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_settings);

        Spinner alarmChoices = (Spinner) findViewById(R.id.alarmOptions);

    }
}

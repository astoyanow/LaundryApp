package com.example.laundryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button washerStart;
    private Button dryerStart;
    private Button optionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        washerStart = findViewById(R.id.startWasher);
        dryerStart = findViewById(R.id.startDryer);
        optionButton = findViewById(R.id.optionsButton);
    }
}

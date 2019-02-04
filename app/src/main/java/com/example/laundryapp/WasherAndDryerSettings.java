package com.example.laundryapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.Byte;
import java.lang.*;
import java.util.logging.*;

import java.io.File;
import java.io.FileOutputStream;

public class WasherAndDryerSettings extends AppCompatActivity {

    private Button done;
    String fileName = "timeInput";
    private EditText washTime;
    private EditText dryTime;
    String washerTimer = "WashSavedTime";
    String dryerTimer = "DrySavedTime";
    String fileContentsWash = washTime.getText().toString();
    String fileContentsDry = dryTime.getText().toString();
    FileOutputStream outputStreamWash;
    FileOutputStream outputStreamDry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_and_dryer_settings);

        done = findViewById(R.id.doneButton);
        washTime = findViewById(R.id.WasherTimeInput);
        dryTime = findViewById(R.id.DryerTimeInput);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    outputStreamWash = openFileOutput(washerTimer, Context.MODE_PRIVATE);
                    outputStreamWash.write(fileContentsWash.getBytes());
                    outputStreamWash.close();
                }
                catch (Exception e){
                    e.printStackTrace(); //add logger to log exceptions.
                }
                try{
                    outputStreamDry = openFileOutput(dryerTimer, Context.MODE_PRIVATE);
                    outputStreamDry.write(fileContentsDry.getBytes());
                    outputStreamDry.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });

    }
}

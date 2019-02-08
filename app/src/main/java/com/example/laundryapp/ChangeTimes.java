package com.example.laundryapp;

import android.widget.EditText;

public class ChangeTimes {

    //user enters text into text field
    //program parses input to retrieve time
    //program converts input into milliseconds

    public int getInputtedTime(EditText userInput){
        int time = Integer.parseInt(userInput.getText().toString());
        changeToMillis(time);
        return time;
    }

    public long changeToMillis(int a){
        long convertedNumber = a * 60000;
        return convertedNumber;
    }
}

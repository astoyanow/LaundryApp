package com.example.laundryapp;

import android.widget.EditText;

public class ChangeTimes {

    //user enters text into text field
    //program parses input to retrieve time
    //program converts input into milliseconds

    public static long getInputtedTime(EditText userInput){
        int time = Integer.parseInt(userInput.getText().toString());
        changeToMillis(time);
        return time;
    }

    public static long changeToMillis(int a){
        long convertedNumber = a * 60000;
        return convertedNumber;
    }
}

package com.example.laundryapp;


public class ChangeTimes {

    //user enters text into text field
    //program parses input to retrieve time
    //program converts input into milliseconds



    public static int getInputtedTime(String userInput){
        String [] values = userInput.split(":");
        int minutes = 0;
        int seconds = 0;
        if (values.length == 1){
            minutes = Integer.valueOf(values[0]);
            minutes = changeToMillis(minutes);
        }
        else{
            minutes = Integer.valueOf(values[0]);
            seconds = Integer.valueOf(values[1]);
            minutes = changeToMillis(minutes);
            seconds = seconds * 1000;
        }
        return minutes + seconds;
    }

    public static int changeToMillis(int a){
        int convertedNumber = a * 60000;
        return convertedNumber;
    }
}

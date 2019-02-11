package com.example.laundryapp;

import android.widget.EditText;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataManagement {

    private File saveDirectory;

    public DataManagement(File saveDirectory){
        this.saveDirectory = saveDirectory;
    }

    public void saveTime(EditText userInputtedTime) throws IOException{
        long convertedTime = ChangeTimes.getInputtedTime(userInputtedTime);
        String a = "SaveTime" + convertedTime;
        File output = new File(saveDirectory, a);
        PrintWriter pw = new PrintWriter(new FileWriter(output));
        pw.println(a);
        pw.close();
    }

    public long openSavedTime (String time) throws FileNotFoundException {
        File input = new File(saveDirectory, time);
        Scanner s = new Scanner(input);
        String text = s.nextLine();
        s.close();
        long retrievedTime = Integer.parseInt(text);
        return retrievedTime;
    }
}

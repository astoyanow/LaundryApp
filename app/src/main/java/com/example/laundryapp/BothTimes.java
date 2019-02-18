package com.example.laundryapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BothTimes {
    private long wash, dry;

    public static String SAVE_FILE_NAME = "SaveFile";

    public static BothTimes open(File saveDirectory) throws FileNotFoundException {
        File input = new File(saveDirectory, SAVE_FILE_NAME);
        Scanner s = new Scanner(input);
        String washLine = s.nextLine();
        String dryLine = s.nextLine();
        s.close();

        BothTimes result = new BothTimes();
        result.wash = Long.parseLong(washLine);
        result.dry = Long.parseLong(dryLine);
        return result;
    }

    private BothTimes() {}

    public BothTimes(String wash, String dry) {
        this.wash = ChangeTimes.getInputtedTime(wash);
        this.dry = ChangeTimes.getInputtedTime(dry);
    }

    public long getWashTime() {return wash;}
    public long getDryTime() {return dry;}

    //public long getWashMinutes() {

   // }

    public void save(File saveDirectory) throws IOException {
        File output = new File(saveDirectory, SAVE_FILE_NAME);
        PrintWriter pw = new PrintWriter(new FileWriter(output));
        pw.println(wash);
        pw.println(dry);
        pw.close();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof BothTimes) {
            BothTimes that = (BothTimes)other;
            return this.wash == that.wash && this.dry == that.dry;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Wash:" + wash + ";Dry:" + dry;
    }
}

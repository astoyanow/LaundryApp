package com.example.laundryapp;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void changeToMillis_isCorrect(){ assertEquals(420000, ChangeTimes.changeToMillis(7));}

    @Test
    public void getInputtedTime_isCorrect(){assertEquals(65000, ChangeTimes.getInputtedTime("1:05"));}

    @Test
    public void CountdownTimer_updateTimeLeft_isCorrect() {
        CountdownTimer timer = new CountdownTimer();
        timer.changeTimerDuration(2, 0);
        assertEquals("2:00", timer.updateTimeLeft());

        timer.changeTimerDuration(13, 5);
        assertEquals("13:05", timer.updateTimeLeft());
    }

    @Test
    public void BothTimes_save_load_ok() throws IOException {
        BothTimes bt = new BothTimes("10", "15");
        bt.save(new File("."));

        BothTimes bt2 = BothTimes.open(new File("."));
        assertEquals(bt, bt2);
    }

}
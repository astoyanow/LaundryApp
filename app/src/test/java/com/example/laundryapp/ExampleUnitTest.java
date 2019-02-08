package com.example.laundryapp;

import org.junit.Test;

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
    public void changeToMillis_isCorrect(){ assertEquals(420000, 420000);}

    @Test
    public void getInputtedTime_isCorrect(){assertEquals(1620000, 1620000);}
}
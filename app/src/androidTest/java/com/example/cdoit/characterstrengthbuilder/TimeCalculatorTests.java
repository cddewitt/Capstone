package com.example.cdoit.characterstrengthbuilder;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;


/**
 * Created by Jessica on 2/17/2016.
 */
public class TimeCalculatorTests {

    TimeCalculator calculator = new TimeCalculator();
    DateTime date;

    @Test
    public void testGetCurrentDate() {
        int actual = calculator.getCurrentDate().getDayOfYear();
        int expected = date.getDayOfYear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculatorReturnsCorrectAmountOfTime_1day() {
        int actual = calculator.getTimeInterval(calculator.getCurrentDate().plusDays(1));
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculatorReturnsCorrectAmountOfTime_1week() {

    }
}

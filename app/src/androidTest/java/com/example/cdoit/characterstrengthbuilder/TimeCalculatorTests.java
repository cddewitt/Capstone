package com.example.cdoit.characterstrengthbuilder;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.sql.Date;


public class TimeCalculatorTests {

    TimeCalculator calculator = new TimeCalculator();
    DateTime date;

    @Test
    public void testGetCurrentDate(){
        LocalDate todayDate = date.toLocalDate();
        LocalDate actual = calculator.getCurrentDate();
        Assert.assertEquals(todayDate,actual);
    }


    @Test
    public void testCalculatorReturnsCorrectAmountOfTime_1day(){
        LocalDate tomorrow = calculator.getCurrentDate().plusDays(1);
        int actual = calculator.getTimeInterval(tomorrow);
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCalculatorReturnsCorrectAmountOfTime_1week(){

    }
}

package com.example.cdoit.characterstrengthbuilder;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;

import java.sql.Date;


/**
 * Created by Jessica on 2/17/2016.
 */
public class TimeCalculatorTests {

    TimeCalculator calculator = new TimeCalculator();
    DateTime date;

    @Test
    public void testGetCurrentDate(){
        int actual = calculator.getCurrentDate();
        int expected = date.getDayOfYear();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void testCalcutorReturnsCorrectAmountOfTime_1day(){

    }

    @Test
    public void testCalculatorReturnsCorrectAmountOfTime_1week(){

    }
}

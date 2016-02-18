package com.example.cdoit.characterstrengthbuilder;

import android.database.sqlite.SQLiteDatabase;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Date;


/**
 * Created by Jessica on 2/17/2016.
 *
 * Calculates time until/since set goal date then holds the data to be used in the notification
 */
public class TimeCalculator {
    private DateTime completionDate; //saved in the db after being made
    private int currentDate;
    private int timeBetweenDates;
    private Date date;
    private DateTime calendar = new DateTime();

    public int getCurrentDate() {
        currentDate = calendar.getDayOfYear();
        return currentDate;
    }

    public int getCompletionDateFrom(String wish, DatabaseHelper db) {
        completionDate = db.getDeadlineDate(wish);
        int completionInt = completionDate.getDayOfYear();
        return completionInt;
    }


}

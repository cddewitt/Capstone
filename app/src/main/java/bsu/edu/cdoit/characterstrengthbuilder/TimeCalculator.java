package bsu.edu.cdoit.characterstrengthbuilder;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;


/**
 * Created by Jessica on 2/17/2016.
 * <p/>
 * Calculates time until/since set goal date then holds the data to be used in the notification
 */
public class TimeCalculator {
    private DateTime completionDate; //saved in the db after being made
    private LocalDate currentDate;
    private Days timeBetweenDates;
    private DateTime calendar = new DateTime();

    public LocalDate getCurrentDate() {
        currentDate = calendar.toLocalDate();
        return currentDate;
    }

    public LocalDate getCompletionDateFrom(String wish, DatabaseHelper db) {
        completionDate = db.getDeadlineDate(wish);
        LocalDate deadline = completionDate.toLocalDate();
        return deadline;
    }

    public int getTimeInterval(LocalDate day) {
        timeBetweenDates = Days.daysBetween(getCurrentDate(), day);
        return timeBetweenDates.getDays();
    }


    public LocalDate getFiveDaysBefore(LocalDate completionDate) {
        LocalDate fiveDaysBefore = null;
        int timeInterval = getTimeInterval(completionDate);
        if (timeInterval == 5) {
            fiveDaysBefore = currentDate;
        }
        return fiveDaysBefore;
    }

    public LocalDate getDateFiveDaysFromNow() {
        LocalDate fiveDaysFromNow = currentDate.plusDays(5);
        return fiveDaysFromNow;
    }

    public LocalDate getNextDay() {
        LocalDate today = getCurrentDate();
        LocalDate tomorrow = today.plusDays(1);
        return tomorrow;
    }
}

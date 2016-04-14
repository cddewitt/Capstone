package com.example.cdoit.characterstrengthbuilder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

public class ReviewActivity extends AppCompatActivity {

    private TextView goalTextView;
    private TextView resultTextView;
    private TextView inteferencePlanTextView;
    private TextView deadlineTextView;
    private TextView characteristicView;

    private String characteristic;
    private String goal;
    private String result;
    private String inteference;
    private String plan;
    private String deadlineDate;
    private List<String> inteferences;
    private List<String> plans;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.grip_review);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            goal = extras.getString("Goal");
            result = extras.getString("Result");
            inteference = extras.getString("Interferences");
            plan = extras.getString("Plan");
            deadlineDate = extras.getString("Deadline_Date");
            inteferences = Arrays.asList(inteference.split("~"));
            plans = Arrays.asList(plan.split("~"));
        }

        goalTextView = (TextView) findViewById(R.id.yourGoaIsTextView);
        resultTextView = (TextView) findViewById(R.id.theBestResultTextView);
        inteferencePlanTextView = (TextView) findViewById(R.id.theMainInteferencesTextView);
        deadlineTextView = (TextView) findViewById(R.id.yourDeadlineIsTextView);
        characteristicView = (TextView) findViewById(R.id.tbxReviewCharacteristic);

        goalTextView.append(goal);
        resultTextView.append(result);
        for (int i = 0; i < inteferences.size(); i++) {
            inteferencePlanTextView.append("Your plan to combat " + inteferences.get(i) + " is to " + plans.get(i) + "!\n\n");

        }
        if (deadlineDate.equals(DatabaseContract.NO_DATE))
            deadlineTextView.setText("");
        else
            deadlineTextView.append(" " + deadlineDate);
        characteristicView.append(characteristic);
    }

    public void saveYourGripButtonClick(View v) {
        long row = insertIncompleteGoalData();
        if (row != -1) {
            setNotificationAlarms();
            Intent intent = new Intent(this, SaveActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "GRIP successfully saved!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Had trouble saving your GRIP. Please try again.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void setNotificationAlarms() {
        if (!deadlineDate.equals(DatabaseContract.NO_DATE)) {
            setDeadlinePassedNotification();
            setFiveDaysLeftNotification();
        }
    }

    private void setDeadlinePassedNotification() {
        Long notificationTime = formatter.parseDateTime(deadlineDate)
                .withTimeAtStartOfDay()
                .withZone(DateTimeZone.forTimeZone(TimeZone.getDefault()))
                .plusDays(1)
                .getMillis();
        Intent alarmIntent = new Intent(this, DeadlinePassedAlarmReceiver.class);
        alarmIntent.putExtra("goal", goal);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, notificationTime, pendingIntent);
        } else {
            manager.set(AlarmManager.RTC_WAKEUP, notificationTime, pendingIntent);
        }
    }


    private void setFiveDaysLeftNotification() {
        DateTime dateFiveDaysBefore = formatter.parseDateTime(deadlineDate)
                .withTimeAtStartOfDay()
                .withZone(DateTimeZone.forTimeZone(TimeZone.getDefault()))
                .minusDays(5);
        Long notificationTime = dateFiveDaysBefore.getMillis();
        Intent alarmIntent = new Intent(this, FiveDaysAlarmReceiver.class);
        alarmIntent.putExtra("goal", goal);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, notificationTime, pendingIntent);
        } else {
            manager.set(AlarmManager.RTC_WAKEUP, notificationTime, pendingIntent);
        }
    }

    private long insertIncompleteGoalData() {
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseContract.IncompleteGoals.COLUMN_GOAL, goal);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_RESULT, result);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_INTERFERENCE, inteference);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_PLAN, plan);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE, deadlineDate);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED, System.currentTimeMillis());

        return db.insert(DatabaseContract.IncompleteGoals.TABLENAME, null, values);
    }
}


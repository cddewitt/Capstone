package com.example.cdoit.characterstrengthbuilder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.TimeZone;

public class ReviewActivity extends AppCompatActivity {

    private TextView wishTextView;
    private TextView outcomeTextView;
    private TextView obstacleTextView;
    private TextView planTextView;
    private TextView deadlineTextView;

    private String wish;
    private String outcome;
    private String obstacle;
    private String plan;
    private String deadlineDate;
    private String deadlineTime;
    private int hour;
    private int minute;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_review);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacle = extras.getString("Obstacle");
            plan = extras.getString("Plan");
            deadlineDate = extras.getString("Deadline_Date");
            deadlineTime = extras.getString("Deadline_Time");
        }

        wishTextView = (TextView) findViewById(R.id.yourWishIsTextView);
        outcomeTextView = (TextView) findViewById(R.id.theBestOutcomeIsTextView);
        obstacleTextView = (TextView) findViewById(R.id.theMainObstacleIsTextView);
        planTextView = (TextView) findViewById(R.id.yourPlanToCombatItIsTextView);
        deadlineTextView = (TextView) findViewById(R.id.yourDeadlineIsTextView);

        wishTextView.append(wish);
        outcomeTextView.append(outcome);
        obstacleTextView.append(obstacle);
        planTextView.append(plan);
        deadlineTextView.append(deadlineDate + " at " + deadlineTime);
    }

    public void saveYourWoopButtonClick(View v) {
        Log.v("Review", "in click");
        long row = insertIncompleteGoalData();
        if (row != -1) {
            setNotificationAlarms();
            Intent intent = new Intent(this, SaveActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "WOOP successfully saved!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Had trouble saving your WOOP. Please try again.", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void setNotificationAlarms() {
        setFiveDaysLeftNotification();
        setDeadlinePassedNotification();
    }

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("HH:MM");


    private void setDeadlinePassedNotification() {
        Long notificationTime = formatter.parseDateTime(deadlineDate)
                .withTimeAtStartOfDay()
                .withZone(DateTimeZone.forTimeZone(TimeZone.getDefault()))
                .plusDays(1)
                .getMillis();
        Intent alarmIntent = new Intent(this, DeadlinePassedAlarmReceiver.class /*needs to be a receiver*/);
        alarmIntent.putExtra("wish", wish);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME, notificationTime, pendingIntent);
        } else {
            manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, notificationTime, pendingIntent);
        }
    }


    private void setFiveDaysLeftNotification() {
        DateTime dateFiveDaysBefore = formatter.parseDateTime(deadlineDate)
                .withTimeAtStartOfDay()
                .withZone(DateTimeZone.forTimeZone(TimeZone.getDefault()))
                .minusDays(5);
        Long notificationTime = dateFiveDaysBefore.getMillis();
        Intent alarmIntent = new Intent(this, DeadlinePassedAlarmReceiver.class /*needs to be a reciever*/);
        alarmIntent.putExtra("wish", wish);
        String ofDate = dateFiveDaysBefore.toString(formatter);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME, notificationTime, pendingIntent);
        } else {
            manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, notificationTime, pendingIntent);
        }
    }

    private long insertIncompleteGoalData() {
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseContract.IncompleteGoals.COLUMN_WISH, wish);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_OUTCOME, outcome);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_OBSTACLE, obstacle);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_PLAN, plan);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE, deadlineDate);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_TIME, deadlineTime);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED, System.currentTimeMillis());

        return db.insert(DatabaseContract.IncompleteGoals.TABLENAME, null, values);
    }
}

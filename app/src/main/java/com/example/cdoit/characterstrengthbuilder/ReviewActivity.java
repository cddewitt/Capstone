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

    private TextView wishTextView;
    private TextView outcomeTextView;
    private TextView obstaclePlanTextView;
    private TextView deadlineTextView;
    private TextView characteristicView;

    private String characteristic;
    private String wish;
    private String outcome;
    private String obstacle;
    private String plan;
    private String deadlineDate;
    private List<String> obstacles;
    private List<String> plans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_review);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacle = extras.getString("Obstacle");
            plan = extras.getString("Plan");
            deadlineDate = extras.getString("Deadline_Date");
            obstacles = Arrays.asList(obstacle.split("~"));
            plans = Arrays.asList(plan.split("~"));
        }

        wishTextView = (TextView) findViewById(R.id.yourWishIsTextView);
        outcomeTextView = (TextView) findViewById(R.id.theBestOutcomeIsTextView);
        obstaclePlanTextView = (TextView) findViewById(R.id.theMainObstacleIsTextView);
        deadlineTextView = (TextView) findViewById(R.id.yourDeadlineIsTextView);
        characteristicView = (TextView) findViewById(R.id.tbxReviewCharacteristic);

        wishTextView.append(wish);
        outcomeTextView.append(outcome);
        for(int i=0;i<obstacles.size();i++)
        {
            obstaclePlanTextView.append("Your plan to combat "+obstacles.get(i)+" is to "+plans.get(i)+"!\n\n");

        }
        if(deadlineDate.equals(DatabaseContract.NO_DATE))
            deadlineTextView.setText("");
        else
            deadlineTextView.append(" " + deadlineDate);
        characteristicView.append(characteristic);
    }

    public void saveYourWoopButtonClick(View v) {
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
        if (!deadlineDate.equals(DatabaseContract.NO_DATE)) {
            setDeadlinePassedNotification();
            setFiveDaysLeftNotification();
        }
    }

    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    private void setDeadlinePassedNotification() {
        Long notificationTime = formatter.parseDateTime(deadlineDate)
                .withTimeAtStartOfDay()
                .withZone(DateTimeZone.forTimeZone(TimeZone.getDefault()))
                .plusDays(1)
                .getMillis();
        Intent alarmIntent = new Intent(this, DeadlinePassedAlarmReceiver.class);
        alarmIntent.putExtra("wish", wish);

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
            alarmIntent.putExtra("wish", wish);
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

        values.put(DatabaseContract.IncompleteGoals.COLUMN_WISH, wish);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_OUTCOME, outcome);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_OBSTACLE, obstacle);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_PLAN, plan);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE, deadlineDate);
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED, System.currentTimeMillis());

        return db.insert(DatabaseContract.IncompleteGoals.TABLENAME, null, values);
    }
}


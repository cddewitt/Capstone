package com.example.cdoit.characterstrengthbuilder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {

    private TextView wishTextView;
    private TextView outcomeTextView;
    private TextView obstacleTextView;
    private TextView planTextView;
    private TextView deadlineTextView;
    private TextView characteristicView;

    private String characteristic;
    private String wish;
    private String outcome;
    private String obstacle;
    private String plan;
    private String deadlineDate;
    private String deadlineTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_review);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic=extras.getString("Characteristic");
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
        characteristicView=(TextView) findViewById(R.id.tbxReviewCharacteristic);

        wishTextView.append(wish);
        outcomeTextView.append(outcome);
        obstacleTextView.append(obstacle);
        planTextView.append(plan);
        deadlineTextView.append(deadlineDate + " at " + deadlineTime);
        characteristicView.append(characteristic);
    }

    public void saveYourWoopButtonClick(View v) {
        long row = insertIncompleteGoalData();
        if (row != -1) {
            Intent intent = new Intent(this, SaveActivity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(this, "WOOP successfully saved!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Had trouble saving your WOOP. Please try again.", Toast.LENGTH_LONG);
            toast.show();
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

package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class GoalDetailActivity extends AppCompatActivity {

    private TextView tbxWish;
    private TextView tbxOutcome;
    private TextView tbxObstacles;
    private TextView tbxPlan;
    private TextView tbxDate;
    private TextView tbxTime;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        Bundle extras = getIntent().getExtras();
        grabTextViews();
        String rowID = extras.getString("RowID");
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, DatabaseContract.IncompleteGoals.COLUMN_ID + "=" + rowID, null, null, null, null);
        if (cursor.moveToFirst()) {
            tbxWish.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_WISH)));
            tbxOutcome.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_OUTCOME)));
            tbxObstacles.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_OBSTACLE)));
            tbxPlan.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_PLAN)));
            tbxDate.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE)));
            tbxTime.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_TIME)));
        }

    }

    private void grabTextViews() {
        tbxWish = (TextView) findViewById(R.id.tbxDetailWish);
        tbxOutcome = (TextView) findViewById(R.id.tbxDetailOutcome);
        tbxObstacles = (TextView) findViewById(R.id.tbxDetailObstacles);
        tbxPlan = (TextView) findViewById(R.id.tbxDetailPlan);
        tbxDate = (TextView) findViewById(R.id.tbxDetailDate);
        tbxTime = (TextView) findViewById(R.id.tbxDetailTime);
    }
}

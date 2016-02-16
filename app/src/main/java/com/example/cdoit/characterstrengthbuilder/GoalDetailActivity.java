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
    private TextView tbxDateCreated;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        Bundle extras = getIntent().getExtras();
        grabTextViews();
        String rowID = extras.getString("RowID");
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db= helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME,null,DatabaseContract.IncompleteGoals.COLUMN_ID+"="+rowID,null,null,null,null);
        if(cursor.moveToFirst())
        {
            tbxWish.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_WISH)));
            tbxOutcome.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_OUTCOME)));
            tbxObstacles.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_OBSTACLE)));
            tbxPlan.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_PLAN)));
            long dateCreated = cursor.getLong(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED));
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(dateCreated);
            tbxDateCreated.setText(cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH));
            tbxDate.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE)));
        }

    }

    private void grabTextViews() {
        tbxWish=(TextView)findViewById(R.id.tbxDetailWish);
        tbxDate=(TextView)findViewById(R.id.tbxDetailDate);
        tbxObstacles=(TextView)findViewById(R.id.tbxDetailObstacles);
        tbxPlan=(TextView)findViewById(R.id.tbxDetailPlan);
        tbxOutcome=(TextView)findViewById(R.id.tbxDetailOutcome);
        tbxDateCreated=(TextView)findViewById(R.id.tbxDetailDateCreated);
    }
}

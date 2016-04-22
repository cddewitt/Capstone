package com.example.cdoit.characterstrengthbuilder;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AnalysisLinkActivity extends AppCompatActivity {
    private TextView completedGRIP;
    private TextView incompleteGRIP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Analysis");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.analysis_link);

        completedGRIP = (TextView) findViewById(R.id.numComplete);
        completedGRIP.setText("Number of completed GRIPs: " + getCompletedGoals());
        incompleteGRIP = (TextView) findViewById(R.id.numIncomplete);
        incompleteGRIP.setText("Number of incompleted GRIPs: " + getIncompleteGoals());
    }

    public void btnAnalysisClick(View v) {
        Intent intent = new Intent(this, RateYourselfActivity.class);
        startActivity(intent);
    }

    public void btnGraphClick(View v) {
        Intent intent = new Intent(this, AnalysisActivity.class);
        startActivity(intent);
    }

    private int getCompletedGoals() {
        int completedGoals = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.CompleteGoals.TABLENAME, null, null, null, null, null, null);
        try {
            if (cursor != null)//check to see if we got any result back
            {
                while (cursor.moveToNext()) {
                    completedGoals++;
                }
            }
        } finally {
            cursor.close();
        }
        return completedGoals;
    }

    private int getIncompleteGoals() {
        int incompleteGoals = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, null, null, null, null, null);
        try {
            if (cursor != null)//check to see if we got any result back
            {
                while (cursor.moveToNext()) {
                    incompleteGoals++;
                }
            }
        } finally {
            cursor.close();
        }
        return incompleteGoals;
    }
}

package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView currentDate;
    private TextView completedGRIP;
    private TextView incompleteGRIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.main);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("MMM dd");
        String strDate = "Today, " + mdformat.format(calendar.getTime());

        currentDate = (TextView) findViewById(R.id.dateText);
        currentDate.setText(strDate);

        completedGRIP = (TextView) findViewById(R.id.numComplete);
        completedGRIP.setText("Number of completed GRIPs: " + getCompletedGoals());
        incompleteGRIP = (TextView) findViewById(R.id.numIncomplete);
        incompleteGRIP.setText("Number of incompleted GRIPs: " + getIncompleteGoals());

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

    private long[] getDatabaseValues() {

        long[] dateCreated = new long[getIncompleteGoals()];
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, null, null, null, null, null);
        if (cursor != null) {
            int i = 0;
            while (cursor.moveToNext()) {
                dateCreated[i] = cursor.getLong(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED));
                i++;
            }
        }
        return dateCreated;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnGoalClick(View v) {
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }


    public void btnAnalysisClick(View v) {
        Intent intent = new Intent(this, AnalysisLinkActivity.class);
        startActivity(intent);
    }

    public void btnTheoryClick(View v) {
       // Intent intent = new Intent(this, RateYourselfActivity.class);
       // startActivity(intent);
    }

    public void btnLovelyThinkingClick(View v) {
        Intent intent = new Intent(this, LovelyThinkingActivity.class);
        startActivity(intent);
    }
    public void btnDonateClick(View v) {
        //    Intent intent = new Intent(this, LearnMore.class);
        //    startActivity(intent);
    }
}
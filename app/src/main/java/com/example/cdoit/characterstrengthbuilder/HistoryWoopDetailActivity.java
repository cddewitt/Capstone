package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;

public class HistoryWoopDetailActivity extends AppCompatActivity {

    private TextView tbxWish;
    private TextView tbxOutcome;
    private TextView tbxObstacles;
    private TextView tbxPlan;
    private TextView tbxDateDeadline;
    private TextView tbxTimeDeadline;
    private TextView tbxCreatedOn;
    private TextView tbxCompletedOn;
    private SQLiteDatabase db;
    private int rowID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_woop_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        grabTextViews();
        rowID = Integer.parseInt(extras.getString("RowID"));
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.CompleteGoals.TABLENAME, null, DatabaseContract.CompleteGoals.COLUMN_ID + "=" + rowID, null, null, null, null);
        if (cursor.moveToFirst()) {
            tbxWish.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_WISH)));
            tbxOutcome.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_OUTCOME)));
            tbxObstacles.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_OBSTACLE)));
            tbxPlan.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_PLAN)));
            tbxDateDeadline.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_DEADLINE_DATE)));
            tbxTimeDeadline.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_DEADLINE_TIME)));
            long dateCreated = cursor.getLong(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_DATE_CREATED));
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(dateCreated);
            tbxCreatedOn.setText(cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH));
            long dateCompleted = cursor.getLong(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_DATE_COMPLETED));
            cal.setTimeInMillis(dateCompleted);
            tbxCompletedOn.setText(cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH));
            setTitle(tbxWish.getText().toString());
        }
    }

    private void grabTextViews() {
        tbxWish = (TextView) findViewById(R.id.tbxDetailHistoryWish);
        tbxOutcome = (TextView) findViewById(R.id.tbxDetailHistoryOutcome);
        tbxObstacles = (TextView) findViewById(R.id.tbxDetailHistoryObstacles);
        tbxPlan = (TextView) findViewById(R.id.tbxDetailHistoryPlan);
        tbxDateDeadline = (TextView) findViewById(R.id.tbxDetailHistoryDate);
        tbxTimeDeadline = (TextView) findViewById(R.id.tbxDetailHistoryTime);
        tbxCompletedOn = (TextView) findViewById(R.id.tbxDetailHistoryFinished);
        tbxCreatedOn = (TextView) findViewById(R.id.tbxDetailHistoryTimeCreated);
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
}

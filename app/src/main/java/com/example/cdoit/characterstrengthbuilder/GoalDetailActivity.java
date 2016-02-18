package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class GoalDetailActivity extends AppCompatActivity {

    private TextView tbxWish;
    private TextView tbxOutcome;
    private TextView tbxObstacles;
    private TextView tbxPlan;
    private TextView tbxDate;
    private TextView tbxTime;
    private SQLiteDatabase db;
    private int rowID;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        Bundle extras = getIntent().getExtras();
        grabTextViews();
        String rowID = extras.getString("RowID");
        this.rowID = Integer.parseInt(rowID);
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        db = helper.getWritableDatabase();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_goals_detail, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.delete_goal) {
            deleteGoal(this.rowID);
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteGoal(int id) {
        db.delete(DatabaseContract.IncompleteGoals.TABLENAME, DatabaseContract.IncompleteGoals.COLUMN_ID + "=" + id, null);
        Toast toast = Toast.makeText(getApplicationContext(), "Your WOOP was been deleted", Toast.LENGTH_SHORT);
        toast.show();
    }
}

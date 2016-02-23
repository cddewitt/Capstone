package com.example.cdoit.characterstrengthbuilder;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
    private long dateCreated;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        grabTextViews();
        rowID = Integer.parseInt(extras.getString("RowID"));
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
            dateCreated = cursor.getLong(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED));
            setTitle(tbxWish.getText().toString());
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
            popUpBox();
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void popUpBox() {
        new AlertDialog.Builder(GoalDetailActivity.this)
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this WOOP?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        deleteGoal(rowID);
                        Intent intent = new Intent(GoalDetailActivity.this, GoalsActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

    private void deleteGoal(int id) {
        db.delete(DatabaseContract.IncompleteGoals.TABLENAME, DatabaseContract.IncompleteGoals.COLUMN_ID + "=" + id, null);
        Toast toast = Toast.makeText(getApplicationContext(), "Your WOOP was been deleted", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void btnMarkAsCompletedClick(View v) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.CompleteGoals.COLUMN_WISH, tbxWish.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_OUTCOME, tbxOutcome.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_OBSTACLE, tbxObstacles.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_PLAN, tbxPlan.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_DATE_COMPLETED, System.currentTimeMillis());
        values.put(DatabaseContract.CompleteGoals.COLUMN_DATE_CREATED, dateCreated);
        values.put(DatabaseContract.CompleteGoals.COLUMN_DEADLINE_TIME, tbxTime.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_DEADLINE_DATE, tbxDate.getText().toString());
        long id = db.insert(DatabaseContract.CompleteGoals.TABLENAME, null, values);
        if (id == -1) {
            Toast toast = Toast.makeText(this.getApplicationContext(), "Failed to move WOOP to completed", Toast.LENGTH_LONG);
            toast.show();
        } else {
            deleteGoal(rowID);
            Toast toast = Toast.makeText(this.getApplicationContext(), "WOOP successfully moved to completed", Toast.LENGTH_LONG);
            toast.show();
            Intent intent = new Intent(GoalDetailActivity.this, GoalsActivity.class);
            startActivity(intent);
        }
    }
}

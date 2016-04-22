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

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetcomposer.Card;

import java.util.Arrays;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class GoalDetailActivity extends AppCompatActivity {


    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "ica1nwRH9wGLrCWkhHG2Lfen8";
    private static final String TWITTER_SECRET = "ktK85XZzR7fYK57380FO94euosu8zsc4uxOljqRnLprd2ZhTaa";
    private String interferencesAsString;
    private String plansAsString;
    private TextView tbxGoal;
    private TextView tbxResult;
    private TextView tbxInterferencesAndPlan;
    private TextView tbxDate;
    private SQLiteDatabase db;
    private int rowID;
    private long dateCreated;
    private ShareLinkContent content;
    private ShareDialog shareDialog;
    private Card appCard;
    private String goalName;
    private List<String> interferences;
    private List<String> plans;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        FacebookSdk.sdkInitialize(getApplicationContext());
        CallbackManager callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.goal_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        grabTextViews();
        rowID = Integer.parseInt(extras.getString("RowID"));
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, DatabaseContract.IncompleteGoals.COLUMN_ID + "=" + rowID, null, null, null, null);
        if (cursor.moveToFirst()) {
            goalName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_GOAL));
            tbxGoal.setText(goalName);
            tbxResult.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_RESULT)));
            interferencesAsString = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_INTERFERENCE));
            plansAsString = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_PLAN));
            plans = Arrays.asList(plansAsString.split("~"));
            interferences = Arrays.asList(interferencesAsString.split("~"));
            tbxInterferencesAndPlan.setText("\n");
            for (int i = 0; i < interferences.size(); i++) {
                tbxInterferencesAndPlan.append(interferences.get(i) + " : " + plans.get(i) + "\n\n");
            }
            if (cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE)).equals(DatabaseContract.NO_DATE))
                tbxDate.setText(" No deadline date");
            else
                tbxDate.setText(cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE)));
            dateCreated = cursor.getLong(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED));

        }
        cursor.close();
    }

    private void grabTextViews() {
        tbxGoal = (TextView) findViewById(R.id.tbxDetailGoal);
        tbxResult = (TextView) findViewById(R.id.tbxDetailResult);
        tbxInterferencesAndPlan = (TextView) findViewById(R.id.tbxDetailInterferencesAndPlan);
        tbxDate = (TextView) findViewById(R.id.tbxDetailDate);
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
                .setMessage("Are you sure you want to delete this GRIP?")
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
    }

    public void btnMarkAsCompletedClick(View v) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.CompleteGoals.COLUMN_GOAL, tbxGoal.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_RESULT, tbxResult.getText().toString());
        values.put(DatabaseContract.CompleteGoals.COLUMN_INTERFERENCES, interferencesAsString);
        values.put(DatabaseContract.CompleteGoals.COLUMN_PLAN, plansAsString);
        values.put(DatabaseContract.CompleteGoals.COLUMN_DATE_COMPLETED, System.currentTimeMillis());
        values.put(DatabaseContract.CompleteGoals.COLUMN_DATE_CREATED, dateCreated);
        values.put(DatabaseContract.CompleteGoals.COLUMN_DEADLINE_DATE, tbxDate.getText().toString());
        long id = db.insert(DatabaseContract.CompleteGoals.TABLENAME, null, values);
        if (id == -1) {
            Toast toast = Toast.makeText(this.getApplicationContext(), "Failed to move GRIP to completed", Toast.LENGTH_LONG);
            toast.show();
        } else {
            deleteGoal(rowID);
            Toast toast = Toast.makeText(this.getApplicationContext(), "GRIP successfully moved to completed", Toast.LENGTH_LONG);
            toast.show();
            Intent intent = new Intent(GoalDetailActivity.this, GoalsActivity.class);
            startActivity(intent);
        }
    }
}

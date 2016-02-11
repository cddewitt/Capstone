package com.example.cdoit.characterstrengthbuilder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {

    private TextView tbxWish;
    private TextView tbxOutcome;
    private TextView tbxObstacles;
    private TextView tbxPlan;

    private String wish;
    private String outcome;
    private String obstacles;
    private String plan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_review);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            wish=extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacles=extras.getString("Obstacles");
            plan=extras.getString("Plan");
            Toast toast = Toast.makeText(getApplicationContext(),"Wish: "+wish,Toast.LENGTH_LONG);
            toast.show();
        }
        tbxWish=(TextView)findViewById(R.id.tbxFinalWish);
        tbxOutcome=(TextView)findViewById(R.id.tbxFinalOutcome);
        tbxObstacles=(TextView)findViewById(R.id.tbxFinalObstacles);
        tbxPlan=(TextView)findViewById(R.id.tbxFinalPlan);

        tbxWish.setText(wish);
        tbxOutcome.setText(outcome);
        tbxObstacles.setText(obstacles);
        tbxPlan.setText(plan);
    }

    public void btnReviewClick(View v){
        long row = insertIncompleteGoalData();
        if(row!=-1)
        {
            Intent intent = new Intent(this,GoalsActivity.class);
            startActivity(intent);
            Toast toast =Toast.makeText(this,"WOOP successfully saved!!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast=Toast.makeText(this,"Had trouble Saving your WOOP. Please try again.",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private long insertIncompleteGoalData() {
        DBHelper helper = new DBHelper(getApplicationContext());
        SQLiteDatabase db=helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.IncompleteGoals.COLUMN_WISH,tbxWish.getText().toString());
        values.put(DatabaseContract.IncompleteGoals.COLUMN_OUTCOME,tbxOutcome.getText().toString());
        values.put(DatabaseContract.IncompleteGoals.COLUMN_OBSTACLES,tbxObstacles.getText().toString());
        values.put(DatabaseContract.IncompleteGoals.COLUMN_PLAN,tbxPlan.getText().toString());
        values.put(DatabaseContract.IncompleteGoals.COLUMN_DATECREATED,System.currentTimeMillis());
        return db.insert(DatabaseContract.IncompleteGoals.TABLENAME, null, values);

    }
}

package com.example.cdoit.characterstrengthbuilder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity {

    private TextView tbxWish;
    private TextView tbxObstacles;
    private TextView tbxOutcome;
    private TextView tbxPlan;

    private String wish;
    private String outcome;
    private String obstacles;
    private String plan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.activity_review);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            wish=extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacles=extras.getString("Obstacles");
            plan=extras.getString("Plan");
        }
    }

}

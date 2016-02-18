package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PlanActivity extends AppCompatActivity {

    private TextView tbxPlan;
    private String wish = "";
    private String outcome = "";
    private String obstacles = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_plan);
        tbxPlan = (TextView) findViewById(R.id.planEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacles = extras.getString("Obstacles");
        }
    }

    public void setADeadlineButtonClick(View v) {
        Log.v("Plan", "in click");
        String plan = tbxPlan.getText().toString();
        if (plan.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a plan to overcome the obstacles you may face.", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, DeadlineActivity.class);
            intent.putExtra("Wish", wish);
            intent.putExtra("Outcome", outcome);
            intent.putExtra("Obstacle", obstacles);
            intent.putExtra("Plan", plan);
            startActivity(intent);
        }
    }
}

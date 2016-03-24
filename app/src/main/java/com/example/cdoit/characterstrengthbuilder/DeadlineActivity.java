package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeadlineActivity extends AppCompatActivity {

    private String characteristic="";
    private String wish = "";
    private String outcome = "";
    private String obstacle = "";
    private String plan = "";
    private TextView dateEditText;
    private TextView timeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_deadline);
        dateEditText = (TextView) findViewById(R.id.dateEditText);
        timeEditText = (TextView) findViewById(R.id.timeEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic=extras.getString("Characteristic");
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacle = extras.getString("Obstacle");
            plan = extras.getString("Plan");
        }
    }

    public void reviewYourWoopButtonClick(View v) {
        String deadlineDate = dateEditText.getText().toString();
        String deadlineTime = timeEditText.getText().toString();
        if (deadlineDate.equals("") || deadlineTime.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please select a deadline date and/or time.", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, ReviewActivity.class);
            intent.putExtra("Characteristic",characteristic);
            intent.putExtra("Wish", wish);
            intent.putExtra("Outcome", outcome);
            intent.putExtra("Obstacle", obstacle);
            intent.putExtra("Plan", plan);
            intent.putExtra("Deadline_Date", deadlineDate);
            intent.putExtra("Deadline_Time", deadlineTime);
            startActivity(intent);
        }
    }

}

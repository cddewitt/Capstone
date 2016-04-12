package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class PlanActivity extends AppCompatActivity {

    private TextView currentplan;
    private TextView tbxPlan;
    private String characteristic = "";
    private String goal = "";
    private String result = "";
    private String Interferences = "";
    private List<String> interference;
    private boolean canContinue;
    private int count=0;
    private String plans ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_plan);
        tbxPlan = (TextView) findViewById(R.id.planEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            goal = extras.getString("Goal");
            result = extras.getString("Result");
            Interferences = extras.getString("Interferences");
            interference = Arrays.asList(Interferences.split("~"));
        }
        currentplan= (TextView)findViewById(R.id.whatIsYourPlanTextView);
        currentplan.setText("What is your plan to deal with: " + interference.get(count));

    }

    public void setADeadlineButtonClick(View v) {
        if(count== interference.size())
        {
            Intent intent = new Intent(this, DeadlineActivity.class);
            intent.putExtra("Characteristic", characteristic);
            intent.putExtra("Goal", goal);
            intent.putExtra("Result", result);
            intent.putExtra("Interferences", Interferences);
            intent.putExtra("Plan", plans);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Please finish making plans for each interference before moving on!",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void nextPlanClick(View v){
        if(count== interference.size())
        {
            Toast toast =Toast.makeText(getApplicationContext(),"You have a plan for each Interference. Move on top the review",Toast.LENGTH_LONG);
            toast.show();
        }
        else if(tbxPlan.getText().toString().equals(""))
        {
            Toast toast =Toast.makeText(getApplicationContext(),"Please enter a plan for the displayed Interference",Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            plans+=tbxPlan.getText().toString()+"~";
            count++;
            if(count== interference.size()) {
                currentplan.setText("You have set all your plans!! Click SET A DEADLINE to continue!");
                plans = plans.substring(0, plans.length() - 1);
            }
            else
                currentplan.setText("What is your plan to deal with: "+ interference.get(count));
            tbxPlan.setText("");
        }

    }
}

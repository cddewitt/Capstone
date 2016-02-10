package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OutcomeActivity extends AppCompatActivity {

    private TextView tbxOutcome;
    private String wish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.activity_outcome);
        tbxOutcome=(TextView)findViewById(R.id.tbxOucome);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            wish=extras.getString("Wish");
        }
    }

    public void btnOutcomeClick(View v){
        String outcome = tbxOutcome.getText().toString();
        if(outcome.equals(""))
        {
            Toast toast =Toast.makeText(getApplicationContext(),"Please enter a possible outcome before continuing",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(this, ObstaclesActivity.class);
            intent.putExtra("Wish", wish);
            intent.putExtra("Outcome",outcome);
            startActivity(intent);
        }
    }



}

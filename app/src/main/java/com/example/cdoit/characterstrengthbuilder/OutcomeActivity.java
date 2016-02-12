package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class OutcomeActivity extends AppCompatActivity {

    private TextView tbxOutcome;
    private String wish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_outcome);
        tbxOutcome = (TextView) findViewById(R.id.outcomeEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            wish = extras.getString("Wish");
        }
    }

    public void continueToObstacleButtonClick(View v) {
        String outcome = tbxOutcome.getText().toString();
        if (outcome.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a possible outcome before continuing", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, ObstacleActivity.class);
            intent.putExtra("Wish", wish);
            intent.putExtra("Outcome", outcome);
            startActivity(intent);
        }
    }


}

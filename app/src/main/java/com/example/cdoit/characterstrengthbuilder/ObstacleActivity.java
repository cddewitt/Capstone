package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ObstacleActivity extends AppCompatActivity {

    private TextView tbxObstacles;
    private String characteristic="";
    private String wish = "";
    private String outcome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_obstacle);
        tbxObstacles = (TextView) findViewById(R.id.obstacleEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic=extras.getString("Characteristic");
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
        }
    }

    public void continueToPlanButtonClick(View v) {
        Log.v("Obstacles", "in click");
        String obstacles = tbxObstacles.getText().toString();
        if (obstacles.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a possible obstacle before continuing", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, PlanActivity.class);
            intent.putExtra("Characteristic",characteristic);
            intent.putExtra("Wish", wish);
            intent.putExtra("Outcome", outcome);
            intent.putExtra("Obstacles", obstacles);
            startActivity(intent);
        }
    }

}

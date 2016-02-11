package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ObstaclesActivity extends AppCompatActivity {

    private TextView tbxObstacles;
    private String wish="";
    private String outcome="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.activity_obstacles);
        tbxObstacles=(TextView)findViewById(R.id.tbxObstacles);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            wish=extras.getString("Wish");
            outcome = extras.getString("Outcome");
        }
    }

    public void btnObstaclesClick(View v) {
        String obstacles = tbxObstacles.getText().toString();
        if (obstacles.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a possible obstacle before continuing", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(this,PlanActivity.class);
            intent.putExtra("Wish",wish);
            intent.putExtra("Outcome",outcome);
            intent.putExtra("Obstacles",obstacles);
        }
    }

}

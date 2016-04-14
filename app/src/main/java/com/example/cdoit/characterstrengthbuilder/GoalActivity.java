package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cory on 2/8/2016.
 */
public class GoalActivity extends AppCompatActivity {

    private TextView tbxGoal;
    private String characteristic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Goal");
        setContentView(R.layout.grip_goal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            characteristic = bundle.getString("Characteristic");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void continueToOutcomeButtonClick(View v) {
        tbxGoal = (TextView) findViewById(R.id.goalEditText);
        String goal = tbxGoal.getText().toString();
        if (goal.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a goal before continuing", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("Characteristic", characteristic);
            intent.putExtra("Goal", tbxGoal.getText().toString());
            startActivity(intent);
        }
    }
}




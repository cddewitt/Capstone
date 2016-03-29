package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ObstacleActivity extends AppCompatActivity {

    private String characteristic = "";
    private String wish = "";
    private String outcome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_obstacle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
        }
    }

    public void continueToPlanButtonClick(View v) {
        String obstacles = getObstacles();
        if (obstacles.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a possible obstacle before continuing", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), obstacles, Toast.LENGTH_LONG);
            toast.show();
            Intent intent = new Intent(this, PlanActivity.class);
            intent.putExtra("Characteristic", characteristic);
            intent.putExtra("Wish", wish);
            intent.putExtra("Outcome", outcome);
            intent.putExtra("Obstacles", obstacles);
            startActivity(intent);
        }
    }

    public void addObstacleButtonClick(View v) {
        EditText et = (EditText) findViewById(R.id.obstacleEditText);
        Drawable draw = et.getBackground();
        ViewGroup.LayoutParams lay = et.getLayoutParams();
        lay.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        EditText tv = new EditText(this);
        tv.setHint("Enter one obstacle here...");
        tv.setBackground(draw);
        tv.setLayoutParams(lay);
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                relativeLayout.removeView(v);
                return true;
            }
        });
        relativeLayout.addView(tv);
    }

    public String getObstacles() {
        String answer = "";
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        for (int i = 0; i < relativeLayout.getChildCount(); i++) {
            View view = relativeLayout.getChildAt(i);
            if (view instanceof EditText) {
                TextView obstacle = (TextView) view;
                if (!obstacle.getText().toString().equals("")) {
                    answer += obstacle.getText().toString() + "~";
                }
            }
        }
        if (!answer.equals(""))
            answer = answer.substring(0, answer.length() - 1);
        return answer;
    }
}
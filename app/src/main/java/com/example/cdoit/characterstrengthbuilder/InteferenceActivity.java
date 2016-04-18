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

public class InteferenceActivity extends AppCompatActivity {

    private String characteristic = "";
    private String goal = "";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.grip_interference);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            goal = extras.getString("Goal");
            result = extras.getString("Result");
        }
    }

    public void continueToPlanButtonClick(View v) {
        String Interferences = getInterferences();
        if (Interferences.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "You must enter atleast 1 interference to continue!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, PlanActivity.class);
            intent.putExtra("Characteristic", characteristic);
            intent.putExtra("Goal", goal);
            intent.putExtra("Result", result);
            intent.putExtra("Interferences", Interferences);
            startActivity(intent);
        }
    }

    public void addInterferenceButtonClick(View v) {
        EditText et = (EditText) findViewById(R.id.interferenceEditText);
        Drawable draw = et.getBackground();
        ViewGroup.LayoutParams lay = et.getLayoutParams();
        lay.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        EditText tv = new EditText(this);
        tv.setHint("Enter one interference here...");
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

    public String getInterferences() {
        String answer = "";
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        for (int i = 0; i < relativeLayout.getChildCount(); i++) {
            View view = relativeLayout.getChildAt(i);
            if (view instanceof EditText) {
                TextView interference = (TextView) view;
                if (!interference.getText().toString().equals("")) {
                    answer += interference.getText().toString() + "~";
                }
            }
        }
        if (!answer.equals(""))
            answer = answer.substring(0, answer.length() - 1);
        return answer;
    }
}
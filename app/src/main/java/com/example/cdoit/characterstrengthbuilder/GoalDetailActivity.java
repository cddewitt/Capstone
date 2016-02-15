package com.example.cdoit.characterstrengthbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GoalDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);
        Bundle extras = getIntent().getExtras();
        String rowID = extras.getString("RowID");
        TextView tbx =(TextView)findViewById(R.id.tbxRowID);
        tbx.setText(rowID);



    }
}

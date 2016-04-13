package com.example.cdoit.characterstrengthbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class LovelyThinkingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovely_thinking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView view = (TextView)findViewById(R.id.lovelyTextView);
        if (view != null) {
            view.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

}

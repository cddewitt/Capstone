package com.example.cdoit.characterstrengthbuilder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class thoeryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView view = (TextView) findViewById(R.id.tbxTheory);
        if (view != null) {
            view.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}

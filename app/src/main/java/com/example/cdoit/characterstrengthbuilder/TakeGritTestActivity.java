package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TakeGritTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_grit_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void takeGritTestButtonClick(View v) {
        Intent intent = new Intent(this, GritTestActivity.class);
        startActivity(intent);
    }

    public void retakeGritTestButtonClick(View v) {
        Intent intent = new Intent(this, GritTestActivity.class);
        startActivity(intent);
    }

}

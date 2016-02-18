package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TakeGritTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Grit Test");
        setContentView(R.layout.take_grit_test);
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

package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class SaveActivity extends AppCompatActivity {

    public void returnToHomeButtonClick(View v) {
        Log.v("Save", "in click");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
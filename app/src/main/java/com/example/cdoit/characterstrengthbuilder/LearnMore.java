package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LearnMore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About");
        setContentView(R.layout.learn_more);
    }

    public void btnTheoryClick(View v) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rkwilley.com/duckworth-oettingen"));
        startActivity(implicit);
    }

    public void btnLovelyThinkingClick(View v) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lovelythinking.com/apps/"));
        startActivity(implicit);
    }

    public void btnCharacterClick(View v) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rkwilley.com/character"));
        startActivity(implicit);
    }

}



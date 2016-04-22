package com.example.cdoit.characterstrengthbuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnalysisLinkActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Analysis");
        setContentView(R.layout.analysis_link);
    }

    public void btnAnalysisClick(View v) {
        Intent intent = new Intent(this, RateYourselfActivity.class);
        startActivity(intent);
    }

    public void btnGraphClick(View v) {
        Intent intent = new Intent(this, AnalysisActivity.class);
        startActivity(intent);
    }
}

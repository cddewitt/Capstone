package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnGoalClick(View v) {
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }


    public void btnAnalysisClick(View v) {
        Intent intent = new Intent(this, RateYourselfActivity.class);
        startActivity(intent);
    }

    public void btnTheoryClick(View v) {
        Intent intent = new Intent(this, theoryActivity.class);
        startActivity(intent);
    }

    public void btnLovelyThinkingClick(View v) {
        Intent intent = new Intent(this, LovelyThinkingActivity.class);
        startActivity(intent);
    }
    public void btnDonateClick(View v) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://oki.wish.org/"));
        startActivity(implicit);
    }
}
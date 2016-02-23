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
        setContentView(R.layout.activity_main);
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

    public void gritTestButtonClick(View v) {
        Intent intent = new Intent(this, TakeGritTestActivity.class);
        startActivity(intent);
    }

    public void btnAnalysisClick(View v) {
        Intent intent = new Intent(this, AnalysisActivity.class);
        startActivity(intent);
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

package com.example.cdoit.characterstrengthbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdoit on 11/16/2015.
 */
public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Analysis");
        setContentView(R.layout.progress);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        populateListView();
    }

    private void populateListView() {
        ListView lv = (ListView) findViewById(R.id.lvProgress);
        List<String> factors = new ArrayList<String>();
        factors.add("Grit");
        factors.add("Self-control");
        factors.add("Social Intelligence");
        factors.add("Zest");
        factors.add("Gratitude");
        factors.add("Optimism");
        factors.add("Curiosity");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.progress_list_item, factors);
        lv.setAdapter(arrayAdapter);
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

}

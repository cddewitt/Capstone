package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by cdoit on 11/16/2015.
 */
public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("History");
        setContentView(R.layout.history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        populateListView();

    }

    private void populateListView() {
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.CompleteGoals.TABLENAME, null, null, null, null, null, null);
        if (cursor != null)//check to see if we got any result back
        {
            String[] fields=new String[]{DatabaseContract.CompleteGoals.COLUMN_ID,DatabaseContract.CompleteGoals.COLUMN_WISH};
            int[] textViewIDs= new int[]{R.id.tbxListItemHitstoryID,R.id.tbxListitemHistoryWish};
            SimpleCursorAdapter ca = new SimpleCursorAdapter(getApplicationContext(),R.layout.listitem_history,cursor,fields,textViewIDs,0);
            ListView lv = (ListView) findViewById(R.id.listViewHistory);
            lv.setAdapter(ca);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(),HistoryWoopDetailActivity.class);
                    intent.putExtra("RowID",String.valueOf(id));
                    startActivity(intent);
                }
            });

        }

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

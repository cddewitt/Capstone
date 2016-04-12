package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.BarGraphSeries;

/**
 * Created by tylergreen on 4/7/16.
 */
public class HistoryActivityGraph extends AppCompatActivity {
    private DataPoint[] generateDataPoints() {
        int count = getGoals();
        DataPoint[] values = new DataPoint[count];
        for(int i = 0; i < count; i++) {
            DataPoint v = new DataPoint(i, i*i);
            values[i] = v;
        }
        return values;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.history_graph);
        getGoals();

        GraphView line = (GraphView) this.findViewById(R.id.historyGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(generateDataPoints());
        line.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(generateDataPoints());
        line.addSeries(series2);
    }

    private int getGoals() {
        int completedGoals = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, null, null, null, null, null);
        try {
            if (cursor != null)//check to see if we got any result back
            {
                while (cursor.moveToNext()) {
                    completedGoals++;
                }
            }
        } finally {
            cursor.close();
        }
        getDate();
        return completedGoals;
    }

    private int getDate() {
        long dateTime = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            dateTime = cursor.getLong(2);
        }
        return 0;
    }
}

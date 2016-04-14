package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class LineGraph extends AppCompatActivity {
    private DataPoint[] populateDataPoints() {
        Double[] scores = getDatabaseValues();
        int count = numValues();
        DataPoint[] values;
        values = new DataPoint[count];
        for (int i = 0; i < count; i++) {
            DataPoint v = new DataPoint(i, scores[i]);
            values[i] = v;
        }
        return values;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.graph);

        GraphView line = (GraphView) this.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(populateDataPoints());
        line.addSeries(series);
    }

    private int numValues() {
        int numItemsInDB = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null);
        try {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    numItemsInDB++;
                }
            }
        } finally {
            cursor.close();
        }

        return numItemsInDB;
    }

    private Double[] getDatabaseValues() {
        Double[] scores = new Double[numValues()];
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null);
        if (cursor.moveToLast()) {
            while (cursor.isAfterLast() == false) {
                scores = new Double[]{
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRIT)),
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_SELF_CONTROL)),
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS)),
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_ZEST)),
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRATITUDE)),
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_OPTIMISM)),
                        cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_CURIOSITY))
                };
                cursor.moveToNext();
            }

        }
        return scores;
    }
}

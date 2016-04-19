package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;


public class LineGraph extends AppCompatActivity {
    private String graphString = "";
    private TextView graphName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.graph);
        Bundle i = getIntent().getExtras();
        graphString = i.getString("Analysis");

        graphName = (TextView) findViewById(R.id.linetext);
        graphName.setText(graphString.toUpperCase());

        GraphView line = (GraphView) this.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(populateDataPoints());
        line.addSeries(series);


    }

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

        if(graphString.equals("grit")){
            Toast toast = Toast.makeText(getApplicationContext(),"worked",Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),graphString,Toast.LENGTH_LONG);
            toast.show();
        }


        Double[] scores = new Double[numValues()];
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null);
        if (cursor != null) {
            int i = 0;
            if(graphString.trim().equals("grit")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRIT));
                    i++;
                }

            }
            if(graphString.trim().equals("selfAnalysis")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_SELF_CONTROL));
                    i++;
                }

            }

            if(graphString.trim().equals("communicationSkills")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS));
                    i++;
                }

            }
            if(graphString.trim().equals("zest")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_ZEST));
                    i++;
                }

            }
            if(graphString.trim().equals("gratitude")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRATITUDE));
                    i++;
                }

            }
            if(graphString.trim().equals("optimism")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_OPTIMISM));
                    i++;
                }

            }
            if(graphString.trim().equals("curiosity")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_CURIOSITY));
                    i++;
                }

            }
            else {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_SELF_CONTROL));
                    i++;
                }
            }
        }
        else
        {
            scores = new Double[0];
        }
        db.close();
        return scores;
    }
}

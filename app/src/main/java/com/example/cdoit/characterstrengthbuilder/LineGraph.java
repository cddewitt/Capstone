package com.example.cdoit.characterstrengthbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


public class LineGraph extends AppCompatActivity {
    private SQLiteDatabase db;

    double communicationScore;
    double curoiosityScore;
    double grattitudeScore;
    double gritScore;
    double optimismScore;
    double selfControlScore;
    double zestScore;
    long dateScored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.graph);
        //getDatabaseValues();

        GraphView line = (GraphView) this.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(communicationScore, dateScored),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        line.addSeries(series);
    }

    private void getDatabaseValues() {
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null);
        if(cursor.moveToFirst()) {
            communicationScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS));
            curoiosityScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_CURIOSITY));
            grattitudeScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRATITUDE));
            gritScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRIT));
            optimismScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_OPTIMISM));
            selfControlScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_SELF_CONTROL));
            zestScore = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_ZEST));
            dateScored = cursor.getLong(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_DATE_SCORED));
        }
    }
}

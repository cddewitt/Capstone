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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.graph);

        GraphView line = (GraphView) this.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        line.addSeries(series);
    }

    private void getDatabaseValues() {
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.CompleteGoals.TABLENAME, null, null, null, null, null, null);
        if(cursor != null) {

        }
    }
}

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
    private DataPoint[] populateDataPoints() {
        Double[] scores = getDatabaseValues();
        int count = 10;
        DataPoint[] values;
        if(count != 0)
        {
            values = new DataPoint[count];
            for(int i = 0; i < count; i++) {
                DataPoint v = new DataPoint(i, count);
                values[i] = v;
            }
        }
        else {
            values = new DataPoint[1];
            DataPoint v = new DataPoint(0, 1);
            values[0] = v;
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

    private Double[] getDatabaseValues() {
        Double[] scores = {};
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null);
        if(cursor.moveToLast()) {
            scores = new Double[]{Double.parseDouble(DatabaseContract.GritScores.COLUMN_GRIT),
                    Double.parseDouble(DatabaseContract.GritScores.COLUMN_SELF_CONTROL),
                    Double.parseDouble(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS),
                    Double.parseDouble(DatabaseContract.GritScores.COLUMN_ZEST),
                    Double.parseDouble(DatabaseContract.GritScores.COLUMN_GRATITUDE),
                    Double.parseDouble(DatabaseContract.GritScores.COLUMN_OPTIMISM),
                    Double.parseDouble(DatabaseContract.GritScores.COLUMN_CURIOSITY)};
        }
        return scores;
    }
}

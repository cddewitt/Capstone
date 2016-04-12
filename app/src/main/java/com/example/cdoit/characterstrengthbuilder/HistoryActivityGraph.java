package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.BarGraphSeries;
import android.widget.TextView;

/**
 * Created by tylergreen on 4/7/16.
 */
public class HistoryActivityGraph extends AppCompatActivity {
    private TextView completedGRIP;
    private TextView incompleteGRIP;

    private DataPoint[] generateDataPoints() {
        int count = 10;
        DataPoint[] values = new DataPoint[count];
        for(int i = 0; i < count; i++) {
            DataPoint v = new DataPoint(i, i*i);
            values[i] = v;
        }
        return values;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_graph);
        completedGRIP = (TextView)findViewById(R.id.numComplete);
        completedGRIP.setText("Number of completed GRIPs: "+10);
        incompleteGRIP = (TextView)findViewById(R.id.numIncomplete);
        incompleteGRIP.setText("Number of completed GRIPs: "+10);
        setTitle("GRAPH");

        GraphView line = (GraphView) this.findViewById(R.id.historyGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(generateDataPoints());
        line.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(generateDataPoints());
        series2.setSpacing(50);
        line.addSeries(series2);
    }

    private int getGoals() {
        int completedGoals = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
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
        return completedGoals;
    }
}

package com.example.cdoit.characterstrengthbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by tylergreen on 4/4/16.
 */
public class WoopLineGraph {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.woopGraph);
        //getDatabaseValues();

        GraphView line = (GraphView) this.findViewById(R.id.woopgraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(communicationScore, dateScored),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        line.addSeries(series);
    }
}

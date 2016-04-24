package bsu.edu.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import android.widget.TextView;


public class LineGraph extends AppCompatActivity {
    private String graphString = "";
    private TextView graphName;
    private String graphNameString = "";
    private TextView numTimesTaken;
    private TextView completedGRIPs;
    private TextView incompleteGRIPs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GRAPH");
        setContentView(R.layout.graph);
        Bundle i = getIntent().getExtras();
        graphString = i.getString("Analysis");

        GraphView line = (GraphView) this.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(populateDataPoints());
        line.addSeries(series);

        graphName = (TextView) findViewById(R.id.linetext);
        graphName.setText(graphNameString);

        numTimesTaken = (TextView) findViewById(R.id.numTimesTaken);
        numTimesTaken.setText("You have taken the test " + numValues() + " times");

        completedGRIPs = (TextView) findViewById(R.id.completedGRIPs);
        completedGRIPs.setText("Completed GRIPs in " + graphNameString + ": " + getCompleteGoals());

        incompleteGRIPs = (TextView) findViewById(R.id.incompleteGRIPS);
        incompleteGRIPs.setText("Incomplete GRIPs in " + graphNameString + ": " + getIncompleteGoals());
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
            else {
                numItemsInDB = 1;
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
        if (cursor != null) {
            int i = 0;
            if(graphString.trim().equals("grit")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRIT));
                    i++;
                }
                graphNameString = "Grit";
            }
            if(graphString.trim().equals("selfAnalysis")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_SELF_CONTROL));
                    i++;
                }
                graphNameString = "Self Analysis";
            }

            if(graphString.trim().equals("communicationSkills")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS));
                    i++;
                }
                graphNameString = "Communication Skills";
            }
            if(graphString.trim().equals("zest")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_ZEST));
                    i++;
                }
                graphNameString = "Zest";
            }
            if(graphString.trim().equals("gratitude")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRATITUDE));
                    i++;
                }
                graphNameString = "Gratitude";
            }
            if(graphString.trim().equals("optimism")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_OPTIMISM));
                    i++;
                }
                graphNameString = "Optimism";
            }
            if(graphString.trim().equals("curiosity")) {
                while (cursor.moveToNext()) {
                    scores[i] = cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_CURIOSITY));
                    i++;
                }
                graphNameString = "Curiosity";
            }
            else {
                while (cursor.moveToNext()) {
                    scores[i] = 0.0;
                    i++;
                }
            }
        }
        else
        {
            scores[0] = 0.0;
        }
        db.close();
        return scores;
    }

    private int getCompleteGoals() {
        String strengthName = "";
        int count = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.CompleteGoals.TABLENAME, null, null, null, null, null, null);
        try {
            if (cursor != null)
            {
                if(graphString.trim().equals("grit")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Grit")) {
                            count++;
                        }
                    }
                }
                if(graphString.trim().equals("selfAnalysis")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Self-Control")) {
                            count++;
                        }
                    }
                }

                if(graphString.trim().equals("communicationSkills")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Communication Skills")) {
                            count++;
                        }
                    }

                }
                if(graphString.trim().equals("zest")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Zest")) {
                            count++;
                        }
                    }
                }
                if(graphString.trim().equals("gratitude")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Gratitude")) {
                            count++;
                        }
                    }

                }
                if(graphString.trim().equals("optimism")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Optimism")) {
                            count++;
                        }
                    }
                }
                if(graphString.trim().equals("curiosity")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.CompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Curiosity")) {
                            count++;
                        }
                    }
                }
            }
        } finally {
            cursor.close();
        }
        return count;
    }

    private int getIncompleteGoals() {
        String strengthName = "";
        int count = 0;
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseContract.IncompleteGoals.TABLENAME, null, null, null, null, null, null);
        try {
            if (cursor != null)
            {
                if(graphString.trim().equals("grit")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Grit")) {
                            count++;
                        }
                    }
                }
                if(graphString.trim().equals("selfAnalysis")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Self-Control")) {
                            count++;
                        }
                    }
                }

                if(graphString.trim().equals("communicationSkills")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Communication Skills")) {
                            count++;
                        }
                    }

                }
                if(graphString.trim().equals("zest")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Zest")) {
                            count++;
                        }
                    }
                }
                if(graphString.trim().equals("gratitude")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Gratitude")) {
                            count++;
                        }
                    }

                }
                if(graphString.trim().equals("optimism")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Optimism")) {
                            count++;
                        }
                    }
                }
                if(graphString.trim().equals("curiosity")) {
                    while (cursor.moveToNext()) {
                        strengthName = cursor.getString(cursor.getColumnIndex(DatabaseContract.IncompleteGoals.COLUMN_CHARACTERSTRNGH));
                        if(strengthName.trim().equals("Curiosity")) {
                            count++;
                        }
                    }
                }
            }
        } finally {
            cursor.close();
        }
        return count;
    }
}

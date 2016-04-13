package com.example.cdoit.characterstrengthbuilder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class RateYourselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rate Yourself");
        setContentView(R.layout.rate_yourself);

        final SeekBar gritSeekBar = (SeekBar) this.findViewById(R.id.gritSeekBar);
        final TextView gritScoreTextView = (TextView) this.findViewById(R.id.gritScoreTextView);

        gritSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                gritScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar selfControlSeekBar = (SeekBar) this.findViewById(R.id.selfControlSeekBar);
        final TextView selfControlScoreTextView = (TextView) this.findViewById(R.id.selfControlScoreTextView);

        selfControlSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                selfControlScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar communicationSkillsSeekBar = (SeekBar) this.findViewById(R.id.communicationSkillsSeekBar);
        final TextView communicationSkillsScoreTextView = (TextView) this.findViewById(R.id.communicationSkillsScoreTextView);

        communicationSkillsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                communicationSkillsScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar zestSeekBar = (SeekBar) this.findViewById(R.id.zestSeekBar);
        final TextView zestScoreTextView = (TextView) this.findViewById(R.id.zestScoreTextView);

        zestSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                zestScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar gratitudeSeekBar = (SeekBar) this.findViewById(R.id.gratitudeSeekBar);
        final TextView gratitudeScoreTextView = (TextView) this.findViewById(R.id.gratitudeScoreTextView);

        gratitudeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                gratitudeScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar optimismSeekBar = (SeekBar) this.findViewById(R.id.optimismSeekBar);
        final TextView optimismScoreTextView = (TextView) this.findViewById(R.id.optimismScoreTextView);

        optimismSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                optimismScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar curiositySeekBar = (SeekBar) this.findViewById(R.id.curiositySeekBar);
        final TextView curiosityScoreTextView = (TextView) this.findViewById(R.id.curiosityScoreTextView);

        curiositySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                curiosityScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        populateScores();
    }

    private void populateScores() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null);
        if (cursor.moveToLast()) {
            Double[] scores = new Double[]{
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRIT)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_SELF_CONTROL)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_ZEST)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_GRATITUDE)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_OPTIMISM)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseContract.GritScores.COLUMN_CURIOSITY))
            };
            int[] scoreSeekBarIds = new int[]{R.id.gritSeekBar,
                    R.id.selfControlSeekBar,
                    R.id.communicationSkillsSeekBar,
                    R.id.zestSeekBar,
                    R.id.gratitudeSeekBar,
                    R.id.optimismSeekBar,
                    R.id.curiositySeekBar};
            int[] scoreTextViewIds = new int[]{R.id.gritScoreTextView,
                    R.id.selfControlScoreTextView,
                    R.id.communicationSkillsScoreTextView,
                    R.id.zestScoreTextView,
                    R.id.gratitudeScoreTextView,
                    R.id.optimismScoreTextView,
                    R.id.curiosityScoreTextView};

            for (int i = 0; i < scores.length; i++) {
                if (i == 0) {
                    SeekBar gritSeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView gritScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarGritScore = (scores[i] * 10) - 10;
                    int seekBarGritScoreAsInt = (int) seekBarGritScore;
                    gritSeekBar.setProgress(seekBarGritScoreAsInt);

                    gritScoreTextView.setText(scores[i].toString());
                } else if (i == 1) {
                    SeekBar selfControlSeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView selfControlScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarSelfControlScore = (scores[i] * 10) - 10;
                    int seekBarSelfControlScoreAsInt = (int) seekBarSelfControlScore;
                    selfControlSeekBar.setProgress(seekBarSelfControlScoreAsInt);

                    selfControlScoreTextView.setText(scores[i].toString());
                } else if (i == 2) {
                    SeekBar communicationSkillsSeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView communicationSkillsScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarCommunicationSkillsScore = (scores[i] * 10) - 10;
                    int seekBarCommunicationSkillsScoreAsInt = (int) seekBarCommunicationSkillsScore;
                    communicationSkillsSeekBar.setProgress(seekBarCommunicationSkillsScoreAsInt);

                    communicationSkillsScoreTextView.setText(scores[i].toString());
                } else if (i == 3) {
                    SeekBar zestSeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView zestScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarZestScore = (scores[i] * 10) - 10;
                    int seekBarZestScoreAsInt = (int) seekBarZestScore;
                    zestSeekBar.setProgress(seekBarZestScoreAsInt);

                    zestScoreTextView.setText(scores[i].toString());
                } else if (i == 4) {
                    SeekBar gratitudeSeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView gratitudeScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarGratitudeScore = (scores[i] * 10) - 10;
                    int seekBarGratitudeScoreAsInt = (int) seekBarGratitudeScore;
                    gratitudeSeekBar.setProgress(seekBarGratitudeScoreAsInt);

                    gratitudeScoreTextView.setText(scores[i].toString());
                } else if (i == 5) {
                    SeekBar optimismSeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView optimismScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarOptimismScore = (scores[i] * 10) - 10;
                    int seekBarOptimismScoreAsInt = (int) seekBarOptimismScore;
                    optimismSeekBar.setProgress(seekBarOptimismScoreAsInt);

                    optimismScoreTextView.setText(scores[i].toString());
                } else if (i == 6) {
                    SeekBar curiositySeekBar = (SeekBar) this.findViewById(scoreSeekBarIds[i]);
                    TextView curiosityScoreTextView = (TextView) this.findViewById(scoreTextViewIds[i]);

                    double seekBarCuriosityScore = (scores[i] * 10) - 10;
                    int seekBarCuriosityScoreAsInt = (int) seekBarCuriosityScore;
                    curiositySeekBar.setProgress(seekBarCuriosityScoreAsInt);

                    curiosityScoreTextView.setText(scores[i].toString());
                }
            }
        }
    }

    private long submitScores() {
        TextView gritScoreTextView = (TextView) this.findViewById(R.id.gritScoreTextView);
        TextView selfControlScoreTextView = (TextView) this.findViewById(R.id.selfControlScoreTextView);
        TextView communicationSkillsScoreTextView = (TextView) this.findViewById(R.id.communicationSkillsScoreTextView);
        TextView zestScoreTextView = (TextView) this.findViewById(R.id.zestScoreTextView);
        TextView gratitudeScoreTextView = (TextView) this.findViewById(R.id.gratitudeScoreTextView);
        TextView optimismScoreTextView = (TextView) this.findViewById(R.id.optimismScoreTextView);
        TextView curiosityScoreTextView = (TextView) this.findViewById(R.id.curiosityScoreTextView);

        String gritScore = gritScoreTextView.getText().toString();
        String selfControlScore = selfControlScoreTextView.getText().toString();
        String communicationSkillsScore = communicationSkillsScoreTextView.getText().toString();
        String zestScore = zestScoreTextView.getText().toString();
        String gratitudeScore = gratitudeScoreTextView.getText().toString();
        String optimismScore = optimismScoreTextView.getText().toString();
        String curiosityScore = curiosityScoreTextView.getText().toString();

        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseContract.GritScores.COLUMN_GRIT, gritScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_SELF_CONTROL, selfControlScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_COMMUNICATION_SKILLS, communicationSkillsScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_ZEST, zestScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_GRATITUDE, gratitudeScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_OPTIMISM, optimismScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_CURIOSITY, curiosityScore);
        contentValues.put(DatabaseContract.GritScores.COLUMN_DATE_SCORED, System.currentTimeMillis());

        return database.insert(DatabaseContract.GritScores.TABLENAME, null, contentValues);
    }

    public void takeGritTestButtonClick(View v) {
        Intent intent = new Intent(this, GritTestActivity.class);
        startActivity(intent);
    }

    public void submitSelfEvaluationButtonClick(View v) {
        long rows = submitScores();
        if (rows != -1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Successful insert!", Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
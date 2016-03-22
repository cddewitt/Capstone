package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RateYourselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grit_test);

        final SeekBar gritSeekBar = (SeekBar) this.findViewById(R.id.gritSeekBar);
        final TextView gritScoreTextView = (TextView) this.findViewById(R.id.gritScoreTextView);

        gritSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double progressAsDouble = (progress / 10.0) + 1.0;
                gritScoreTextView.setText(String.valueOf(progressAsDouble));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
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
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
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
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
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
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
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
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
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
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
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
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        populateScores();
    }

    public void populateScores() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null, null);
        if (cursor != null) {
            // TODO: 3/22/2016
        }
    }

    public void takeGritTestButtonClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sasupenn.qualtrics.com/jfe/form/SV_06f6QSOS2pZW9qR"));
        startActivity(intent);
    }

    public void submitSelfEvaluationButtonClick(View v) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null, null);
        if (cursor != null) {
            // TODO: 3/22/2016
        }
    }

}
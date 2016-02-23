package com.example.cdoit.characterstrengthbuilder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TakeGritTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Grit Test");
        setContentView(R.layout.take_grit_test);
    }

    private void gritTestPopUp() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle("Message");
        helpBuilder.setMessage("Please take the test first");
        helpBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                    }
                });

        // Remember, create doesn't show the dialog
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }

    public void takeGritTestButtonClick(View v) {
        Intent intent = new Intent(this, GritTestActivity.class);
        startActivity(intent);
    }

    public void retakeGritTestButtonClick(View v) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.query(DatabaseContract.GritScores.TABLENAME, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            Intent intent = new Intent(this, GritTestActivity.class);
            startActivity(intent);
        } else {
            gritTestPopUp();
        }
    }

}

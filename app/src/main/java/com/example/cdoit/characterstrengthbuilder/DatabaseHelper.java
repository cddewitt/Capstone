package com.example.cdoit.characterstrengthbuilder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cdoit on 2/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int version = 3;

    public DatabaseHelper(Context context) {
        super(context, DatabaseContract.DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_INCOMPLETE_GOALS_TABLE = "CREATE TABLE " + DatabaseContract.IncompleteGoals.TABLENAME + " (" +
                DatabaseContract.IncompleteGoals.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatabaseContract.IncompleteGoals.COLUMN_DATE_CREATED + " LONG NOT NULL," +
                DatabaseContract.IncompleteGoals.COLUMN_WISH + " TEXT NOT NULL, " +
                DatabaseContract.IncompleteGoals.COLUMN_OUTCOME + " TEXT NOT NULL, " +
                DatabaseContract.IncompleteGoals.COLUMN_OBSTACLE + " TEXT NOT NULL, " +
                DatabaseContract.IncompleteGoals.COLUMN_PLAN + " TEXT NOT NULL, " +
                DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_DATE + " TEXT NOT NULL, " +
                DatabaseContract.IncompleteGoals.COLUMN_DEADLINE_TIME + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_SPEED_AND_TOUCH_TABLE = "CREATE TABLE " + DatabaseContract.CompleteGoals.TABLENAME + " (" +
                DatabaseContract.CompleteGoals.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseContract.CompleteGoals.COLUMN_DATE_CREATED + " LONG NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_DATE_COMPLETED + " LONG NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_WISH + " TEXT NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_OUTCOME + " TEXT NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_OBSTACLE + " TEXT NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_PLAN + " TEXT NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_DEADLINE_DATE + " TEXT NOT NULL, " +
                DatabaseContract.CompleteGoals.COLUMN_DEADLINE_TIME + " TEXT NOT NULL " +
                " );";

        db.execSQL(SQL_CREATE_INCOMPLETE_GOALS_TABLE);
        db.execSQL(SQL_CREATE_SPEED_AND_TOUCH_TABLE);
        Log.v("Databse", "Successfully Created Tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.CompleteGoals.TABLENAME);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.IncompleteGoals.TABLENAME);
        Log.v("Databse", "all tables dropped!!");
        onCreate(db);

    }
}

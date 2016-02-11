package com.example.cdoit.characterstrengthbuilder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cdoit on 2/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int version=2;

    public DatabaseHelper(Context context){
        super(context, DatabaseConnect.DB_NAME,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_INCOMPLETEGOALS_TABLE = "CREATE TABLE " + DatabaseConnect.IncompleteGoals.TABLENAME + " (" +
                DatabaseConnect.IncompleteGoals.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatabaseConnect.IncompleteGoals.COLUMN_DATECREATED + " LONG NOT NULL," +
                DatabaseConnect.IncompleteGoals.COLUMN_WISH + " TEXT NOT NULL, " +
                DatabaseConnect.IncompleteGoals.COLUMN_OUTCOME + " TEXT NOT NULL, " +
                DatabaseConnect.IncompleteGoals.COLUMN_OBSTACLES + " TEXT NOT NULL, " +
                DatabaseConnect.IncompleteGoals.COLUMN_PLAN + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_SPEED_AND_TOUCH_TABLE = "CREATE TABLE " + DatabaseConnect.CompleteGoals.TABLENAME + " (" +
                DatabaseConnect.CompleteGoals.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseConnect.CompleteGoals.COLUMN_DATECREATED + " LONG NOT NULL, " +
                DatabaseConnect.CompleteGoals.COLUMN_WISH + " TEXT NOT NULL, " +
                DatabaseConnect.CompleteGoals.COLUMN_OUTCOME + " TEXT NOT NULL, " +
                DatabaseConnect.CompleteGoals.COLUMN_OBSTACLES + " TEXT NOT NULL, " +
                DatabaseConnect.CompleteGoals.COLUMN_PLAN + " TEXT NOT NULL, " +
                DatabaseConnect.CompleteGoals.COLUMN_DATECOMPLETED + " LONG NOT NULL " +
                " );";

        db.execSQL(SQL_CREATE_INCOMPLETEGOALS_TABLE);
        db.execSQL(SQL_CREATE_SPEED_AND_TOUCH_TABLE);
        Log.v("Databse","Successfully Created Tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseConnect.CompleteGoals.TABLENAME);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseConnect.IncompleteGoals.TABLENAME);
        Log.v("Databse", "all tables dropped!!");
        onCreate(db);

    }
}

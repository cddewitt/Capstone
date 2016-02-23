package com.example.cdoit.characterstrengthbuilder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.joda.time.DateTime;

import java.sql.Date;

/**
 * Created by cdoit on 2/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int version = 7;

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

        final String SQL_CREATE_COMPLETE_GOALS_TABLE = "CREATE TABLE " + DatabaseContract.CompleteGoals.TABLENAME + " (" +
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

        final String SQL_CREATE_GRIT_SCORES_TABLE = "CREATE TABLE " + DatabaseContract.GritScores.TABLENAME + " (" +
                DatabaseContract.GritScores.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseContract.GritScores.COLUMN_DATE_SCORED + " LONG NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_SELF_CONTROL + " DOUBLE NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_SOCIAL_INTELLIGENCE + " DOUBLE NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_ZEST + " DOUBLE NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_GRATITUDE + " DOUBLE NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_OPTIMISM + " DOUBLE NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_CURIOSITY + " DOUBLE NOT NULL, " +
                DatabaseContract.GritScores.COLUMN_TOTAL_SCORE + " DOUBLE NOT NULL " +
                " );";

        final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + DatabaseContract.Users.TABLENAME + " (" +
                DatabaseContract.Users.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseContract.Users.COLUMN_USERNAME + " TEXT NOT NULL " +
                DatabaseContract.Users.COLUMN_PASSWORD + " TEXT NOT NULL " + ");";

        db.execSQL(SQL_CREATE_INCOMPLETE_GOALS_TABLE);
        db.execSQL(SQL_CREATE_COMPLETE_GOALS_TABLE);
        db.execSQL(SQL_CREATE_GRIT_SCORES_TABLE);
        db.execSQL(SQL_CREATE_USER_TABLE);
        Log.v("Database", "Successfully Created Tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.CompleteGoals.TABLENAME);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.IncompleteGoals.TABLENAME);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.GritScores.TABLENAME);
        Log.v("Database", "All Tables Dropped");
        onCreate(db);
    }

    public DateTime getDeadlineDate(String wish){
        String query = "SELECT COLUMN_DEADLINE_DATE FROM " + DatabaseContract.IncompleteGoals.TABLENAME + "WHERE " + DatabaseContract.IncompleteGoals.COLUMN_WISH + " =\"" + wish+ "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
        }

       DateTime wishDate = DateTime.parse(cursor.getString(0));
        db.close();
        return wishDate;
    }

    public String getGoalName(String wish){
        String query = "SELECT COLUMN_WISH FROM " + DatabaseContract.IncompleteGoals.TABLENAME + "WHERE " + DatabaseContract.IncompleteGoals.COLUMN_WISH + " =\"" + wish+ "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
        }

        String wishName = cursor.getString(0);
        db.close();
        return wishName;
    }
}

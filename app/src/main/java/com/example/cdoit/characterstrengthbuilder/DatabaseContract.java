package com.example.cdoit.characterstrengthbuilder;

/**
 * Created by cdoit on 2/4/2016.
 */
public class DatabaseContract {

    public static final String DB_NAME = "GoalDataBase";

    public static final class IncompleteGoals {
        public static final String TABLENAME = "IncompleteGoals";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_DATECREATED = "DateCreated";
        public static final String COLUMN_WISH = "Wish";
        public static final String COLUMN_OUTCOME = "Outcome";
        public static final String COLUMN_OBSTACLES = "Obstacles";
        public static final String COLUMN_PLAN = "Plan";
    }

    public static final class CompleteGoals {
        public static final String TABLENAME = "CompleteGoals";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_DATECREATED = "DateCreated";
        public static final String COLUMN_DATECOMPLETED = "DateCompleted";
        public static final String COLUMN_WISH = "Wish";
        public static final String COLUMN_OUTCOME = "Outcome";
        public static final String COLUMN_OBSTACLES = "Obstacles";
        public static final String COLUMN_PLAN = "Plan";
    }

}

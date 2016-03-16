package com.example.cdoit.characterstrengthbuilder;

/**
 * Created by cdoit on 2/4/2016.
 */
public class DatabaseContract {

    public static final String DB_NAME = "GoalDataBase";

    public static final class IncompleteGoals {
        public static final String TABLENAME = "IncompleteGoals";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DATE_CREATED = "DateCreated";
        public static final String COLUMN_WISH = "Wish";
        public static final String COLUMN_OUTCOME = "Outcome";
        public static final String COLUMN_OBSTACLE = "Obstacles";
        public static final String COLUMN_PLAN = "Plan";
        public static final String COLUMN_DEADLINE_DATE = "DeadlineDate";
        public static final String COLUMN_DEADLINE_TIME = "DeadlineTime";
    }

    public static final class CompleteGoals {
        public static final String TABLENAME = "CompleteGoals";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DATE_CREATED = "DateCreated";
        public static final String COLUMN_DATE_COMPLETED = "DateCompleted";
        public static final String COLUMN_WISH = "Wish";
        public static final String COLUMN_OUTCOME = "Outcome";
        public static final String COLUMN_OBSTACLE = "Obstacles";
        public static final String COLUMN_PLAN = "Plan";
        public static final String COLUMN_DEADLINE_DATE = "DeadlineDate";
        public static final String COLUMN_DEADLINE_TIME = "DeadlineTime";
    }

    public static final class GritScores {
        public static final String TABLENAME = "GritScores";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DATE_SCORED = "DateScored";
        public static final String COLUMN_SELF_CONTROL = "SelfControl";
        public static final String COLUMN_SOCIAL_INTELLIGENCE = "SocialIntelligence";
        public static final String COLUMN_ZEST = "Zest";
        public static final String COLUMN_GRATITUDE = "Gratitude";
        public static final String COLUMN_OPTIMISM = "Optimism";
        public static final String COLUMN_CURIOSITY = "Curiosity";
        public static final String COLUMN_TOTAL_SCORE = "TotalScore";
    }

    public static final class Users {
        public static final String TABLENAME = "Users";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_USERNAME = "Username";
        public static final String COLUMN_PASSWORD = "Password";
    }
}

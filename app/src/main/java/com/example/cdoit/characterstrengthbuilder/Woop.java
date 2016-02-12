package com.example.cdoit.characterstrengthbuilder;

import org.json.JSONObject;

/**
 * Created by Alex on 2/9/2016.
 */
public class Woop {

    private String wish;
    private String outcome;
    private String obstacle;
    private String plan;

    private String[] woopInfo;

//    private DateTime startDateTime;
//    private DateTime endDateTime;

    private DatabaseContract dbConnection;

    private JSONObject currentWoopsInJson;
    private JSONObject selectedWoopsInJson;

    public Woop() {
        wish = "";
        outcome = "";
        obstacle = "";
        plan = "";

        woopInfo = new String[4];

//        startDateTime = new DateTime();
//        endDateTime = new DateTime();

        dbConnection = new DatabaseContract();

        currentWoopsInJson = new JSONObject();
        selectedWoopsInJson = new JSONObject();
    }

//    private Woop createNewWoop() {
//
//    }
//
//    private void saveWoop(Woop woop) {
//
//    }
//
//    private Woop[] viewCurrentWoops() {
//
//    }
//
//    private void shareWoop(int site) {
//
//    }
//
//    private void shareFacebook(Woop woop) {
//
//    }
//
//    private void shareTwitter(Woop woop) {
//
//    }

    private void setWish(String wish) {
        this.wish = wish;
    }

    private void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    private void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }

    private void setPlan(String plan) {
        this.plan = plan;
    }

    private String getWish() {
        return wish;
    }

    private String getOutcome() {
        return outcome;
    }

    private String getObstacle() {
        return obstacle;
    }

    private String getPlan() {
        return plan;
    }



}

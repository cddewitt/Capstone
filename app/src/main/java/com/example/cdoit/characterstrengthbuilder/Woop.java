package com.example.cdoit.characterstrengthbuilder;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Alex on 2/9/2016.
 */
public class Woop {

    private String wish;
    private String outcome;
    private String obstacle;
    private String plan;
    private Date startDateTime;
    private Date endDateTime;

    private String[] woopInfo;

    private DatabaseContract dbConnection;

    private JSONObject currentWoopsInJson;
    private JSONObject selectedWoopsInJson;

    public Woop() {
        wish = "";
        outcome = "";
        obstacle = "";
        plan = "";
        startDateTime = new Date();
        endDateTime = new Date();

        woopInfo = new String[6];

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

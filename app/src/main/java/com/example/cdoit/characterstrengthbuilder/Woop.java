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
    private Date deadlineDate;
    private Date deadlineTime;

    private String[] woopInfo;

    public Woop() {
        wish = "";
        outcome = "";
        obstacle = "";
        plan = "";
        deadlineDate = new Date();
        deadlineTime = new Date();

        woopInfo = new String[6];
    }

//    public Woop createNewWoop() {
//
//    }
//
//    public void saveWoop(Woop woop) {
//
//    }
//
//    public Woop[] viewCurrentWoops() {
//
//    }
//
//    public void shareWoop(int site) {
//
//    }
//
//    public void shareFacebook(Woop woop) {
//
//    }
//
//    public void shareTwitter(Woop woop) {
//
//    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public void setWoopInfo(String[] woopInfo) {
        this.woopInfo = woopInfo;
    }

    public String getWish() {
        return wish;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getObstacle() {
        return obstacle;
    }

    public String getPlan() {
        return plan;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public String[] getWoopInfo() {
        return woopInfo;
    }

}

package com.example.cdoit.characterstrengthbuilder;

import org.json.JSONObject;

/**
 * Created by Alex on 2/9/2016.
 */
public class GritTest {

    private double selfControl;
    private double socialIntelligence;
    private double zest;
    private double gratitude;
    private double optimism;
    private double curiosity;

    private double totalGritScore;

    private double[] gritTestInfo;

    private DatabaseContract dbConnection;

    private JSONObject currentGritTestInfoInJson;

    public GritTest() {
        selfControl = 0;
        socialIntelligence = 0;
        zest = 0;
        gratitude = 0;
        optimism = 0;
        curiosity = 0;

        totalGritScore = 0;

        gritTestInfo = new double[6];

        dbConnection = new DatabaseContract();

        currentGritTestInfoInJson = new JSONObject();
    }

//    private GritTest takeGritTest() {
//
//    }
//
//    private GritTest retakeGritTest() {
//
//    }
//
//    private void saveGritTestResults(GritTest gritTest) {
//
//    }
//
//    private void updateGritTestResults(GritTest gritTest) {
//
//    }
//
//    private GritTest viewCurrentGritTestResults() {
//
//    }
//
//    private void learnAboutGritTest(int site) {
//
//    }

    private void setSelfControl(double selfControl) {
        this.selfControl = selfControl;
    }

    private void setSocialIntelligence(double socialIntelligence) {
        this.socialIntelligence = socialIntelligence;
    }

    private void setZest(double zest) {
        this.zest = zest;
    }

    private void setGratitude(double gratitude) {
        this.gratitude = gratitude;
    }

    private void setOptimism(double optimism) {
        this.optimism = optimism;
    }

    private void setCuriosity(double curiosity) {
        this.curiosity = curiosity;
    }

    private void setTotalGritScore(double totalGritScore) {
        this.totalGritScore = totalGritScore;
    }

    private double getSelfControl() {
        return selfControl;
    }

    private double getSocialIntelligence() {
        return socialIntelligence;
    }

    private double getZest() {
        return zest;
    }

    private double getGratitude() {
        return gratitude;
    }

    private double getOptimism() {
        return optimism;
    }

    private double getCuriosity() {
        return curiosity;
    }

    private double getTotalGritScore() {
        return totalGritScore;
    }

}

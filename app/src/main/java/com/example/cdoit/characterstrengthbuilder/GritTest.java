package com.example.cdoit.characterstrengthbuilder;

import org.json.JSONObject;

/**
 * Created by Alex on 2/9/2016.
 */
public class GritTest {

    private int selfControl;
    private int socialIntelligence;
    private int zest;
    private int gratitude;
    private int optimism;
    private int curiosity;

    private int[] gritTestInfo;

    private int totalGritScore;

    private DatabaseContract dbConnection;

    private JSONObject currentGritTestInfoInJson;

    public GritTest() {
        selfControl = 0;
        socialIntelligence = 0;
        zest = 0;
        gratitude = 0;
        optimism = 0;
        curiosity = 0;

        gritTestInfo = new int[6];

        totalGritScore = 0;

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

    private void setSelfControl(int selfControl) {
        this.selfControl = selfControl;
    }

    private void setSocialIntelligence(int socialIntelligence) {
        this.socialIntelligence = socialIntelligence;
    }

    private void setZest(int zest) {
        this.zest = zest;
    }

    private void setGratitude(int gratitude) {
        this.gratitude = gratitude;
    }

    private void setOptimism(int optimism) {
        this.optimism = optimism;
    }

    private void setCuriosity(int curiosity) {
        this.curiosity = curiosity;
    }

    private int getSelfControl() {
        return selfControl;
    }

    private int getSocialIntelligence() {
        return socialIntelligence;
    }

    private int getZest() {
        return zest;
    }

    private int getGratitude() {
        return gratitude;
    }

    private int getOptimism() {
        return optimism;
    }

    private int getCuriosity() {
        return curiosity;
    }

}

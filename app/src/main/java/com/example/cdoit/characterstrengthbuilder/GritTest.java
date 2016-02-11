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

    private DatabaseConnect dbConnection;

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

        dbConnection = new DatabaseConnect();

        currentGritTestInfoInJson = new JSONObject();
    }

    private GritTest takeGritTest() {

    }

    private GritTest retakeGritTest() {

    }

    private void saveGritTestResults(GritTest gritTest) {

    }

    private void updateGritTestResults(GritTest gritTest) {

    }

    private GritTest viewCurrentGritTestResults() {

    }

    private void learnAboutGritTest(int site) {

    }

}

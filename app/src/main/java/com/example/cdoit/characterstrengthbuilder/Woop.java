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

    private DateTime startDateTime;
    private DateTime endDateTime;

    private DatabaseContract dbConnection;

    private JSONObject currentWoopsInJson;
    private JSONObject selectedWoopsInJson;

    public Woop() {
        wish = "";
        outcome = "";
        obstacle = "";
        plan = "";

        woopInfo = new String[4];

        startDateTime = new DateTime();
        endDateTime = new DateTime();

        dbConnection = new DatabaseContract();

        currentWoopsInJson = new JSONObject();
        selectedWoopsInJson = new JSONObject();
    }

    private Woop createNewWoop() {

    }

    private void saveWoop(Woop woop) {

    }

    private Woop[] viewCurrentWoops() {

    }

    private void shareWoop(int site) {

    }

    private void shareFacebook(Woop woop) {

    }

    private void shareTwitter(Woop woop) {

    }

}

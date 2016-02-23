package com.example.cdoit.characterstrengthbuilder;

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

    public GritTest() {
        selfControl = 0;
        socialIntelligence = 0;
        zest = 0;
        gratitude = 0;
        optimism = 0;
        curiosity = 0;

        totalGritScore = 0;

        gritTestInfo = new double[6];
    }

//    public GritTest takeGritTest() {
//
//    }
//
//    public GritTest retakeGritTest() {
//
//    }
//
//    public void saveGritTestResults(GritTest gritTest) {
//
//    }
//
//    public void updateGritTestResults(GritTest gritTest) {
//
//    }
//
//    public GritTest viewCurrentGritTestResults() {
//
//    }
//
//    public void learnAboutGritTest(int site) {
//
//    }

    public double getSelfControl() {
        return selfControl;
    }

    public void setSelfControl(double selfControl) {
        this.selfControl = selfControl;
    }

    public double getSocialIntelligence() {
        return socialIntelligence;
    }

    public void setSocialIntelligence(double socialIntelligence) {
        this.socialIntelligence = socialIntelligence;
    }

    public double getZest() {
        return zest;
    }

    public void setZest(double zest) {
        this.zest = zest;
    }

    public double getGratitude() {
        return gratitude;
    }

    public void setGratitude(double gratitude) {
        this.gratitude = gratitude;
    }

    public double getOptimism() {
        return optimism;
    }

    public void setOptimism(double optimism) {
        this.optimism = optimism;
    }

    public double getCuriosity() {
        return curiosity;
    }

    public void setCuriosity(double curiosity) {
        this.curiosity = curiosity;
    }

    public double getTotalGritScore() {
        return totalGritScore;
    }

    public void setTotalGritScore(double totalGritScore) {
        this.totalGritScore = totalGritScore;
    }

    public double[] getGritTestInfo() {
        return gritTestInfo;
    }

    public void setGritTestInfo(double[] gritTestInfo) {
        this.gritTestInfo = gritTestInfo;
    }

}

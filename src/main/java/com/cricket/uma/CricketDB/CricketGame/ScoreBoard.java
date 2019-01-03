package com.cricket.uma.CricketDB.CricketGame;

public class ScoreBoard {
    private int currentTotal;
    private int currentOver;
    private int currentBall;
    private int currentWickets;
   // private boolean isFinished;

    public void addBowlOutcome(BowlResult result){
        currentTotal+=result.ordinal();

    }



    public int getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public int getCurrentOver() {
        return currentOver;
    }

    public void setCurrentOver(int currentOver) {
        this.currentOver = currentOver;
    }

    public int getCurrentBall() {
        return currentBall;
    }

    public void setCurrentBall(int currentBall) {
        this.currentBall = currentBall;
    }

    public int getCurrentWickets() {
        return currentWickets;
    }

    public void setCurrentWickets(int currentWickets) {
        this.currentWickets = currentWickets;
    }

//   //


}

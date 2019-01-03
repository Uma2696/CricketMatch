package com.cricket.uma.CricketDB.CricketGame;

public interface DBListener {

   public void updatePlayerRuns(CricketGameResult currentResult,ScoreBoard inningsScoreBoard);
   public void queryResult(CricketGameResult finalResult);
}

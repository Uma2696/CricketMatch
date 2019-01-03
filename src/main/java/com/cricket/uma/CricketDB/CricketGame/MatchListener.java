package com.cricket.uma.CricketDB.CricketGame;

public interface MatchListener {

    void teamSetupCompleted(CricketTeam teamA, CricketTeam teamB);

    void tossCompleted(CricketTeam tossWinner);

    void inningsCompleted(ScoreBoard inningScoreBoard, CricketGameResult currentResult);

    void matchResult(CricketGameResult currentResult, boolean tie);

}

package com.cricket.uma.CricketDB.CricketGame;



public class CricketMatchController {

    protected void startPlayingInnings(ScoreBoard inningScoreBoard,CricketGameResult currentResult, CricketGame.MatchStatus status, int target,MatchListener listener,DBListener dbListener) {
        //Client mongo = new Client("localhost", 27017);

        while (!status.finished && inningScoreBoard.getCurrentWickets() < 10 && (target==0 || target>=inningScoreBoard.getCurrentTotal()) ){
            if (status.running) {
                BowlResult result = throwBall();
                inningScoreBoard.addBowlOutcome(result);
                dbListener.updatePlayerRuns(currentResult,inningScoreBoard);

                inningScoreBoard.setCurrentBall(inningScoreBoard.getCurrentBall() + 1);

                if (result == BowlResult.out) {
                    inningScoreBoard.setCurrentWickets(inningScoreBoard.getCurrentWickets() + 1);
                }
                if (inningScoreBoard.getCurrentBall() == 5) {
                    inningScoreBoard.setCurrentBall(0);
                        if (inningScoreBoard.getCurrentOver() == 50) {
                                status.finished=true;

                        }
                        inningScoreBoard.setCurrentOver(inningScoreBoard.getCurrentOver() + 1);

                    }
                }

            }
        listener.inningsCompleted(inningScoreBoard,currentResult);
        }

// Random method
    private BowlResult throwBall() {
        int run = (int) (Math.random() * 7);
        return BowlResult.values()[run];
    }

    protected void teamScoreCompare(CricketGameResult currentResult,CricketTeam teamA,CricketTeam teamB,MatchListener listener){
            boolean tie=false;
        if(currentResult.getTeamAScore().getCurrentTotal()>currentResult.getTeamBScore().getCurrentTotal()){
            currentResult.setWinningTeam(teamA);
        }else if(currentResult.getTeamAScore().getCurrentTotal()<currentResult.getTeamBScore().getCurrentTotal()){
            currentResult.setWinningTeam(teamB);
        }else {

            tie=true;
        }
        listener.matchResult(currentResult,tie);
    }
}


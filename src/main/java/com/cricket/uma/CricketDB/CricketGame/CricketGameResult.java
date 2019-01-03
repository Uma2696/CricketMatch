package com.cricket.uma.CricketDB.CricketGame;

public class CricketGameResult implements GameResult{
    private CricketTeam winningTeam;
    private CricketTeam currentInningTeam;
    private ScoreBoard teamAScore;
    private ScoreBoard teamBScore;
    private CricketTeam tossWinner;
    private CricketTeam innint1Team;
    private CricketTeam innit2Team;
    private String Match_id;

    public CricketTeam getInnit2Team() {
        return innit2Team;
    }

    public void setInnit2Team(CricketTeam innit2Team) {
        this.innit2Team = innit2Team;
    }

    public CricketTeam getWinningTeam() {

        return winningTeam;
    }

    public void setWinningTeam(CricketTeam winningTeam) {
        this.winningTeam = winningTeam;

    }

    public ScoreBoard getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(ScoreBoard teamAScore) {
        this.teamAScore = teamAScore;
    }

    public ScoreBoard getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(ScoreBoard teamBScore) {
        this.teamBScore = teamBScore;
    }

    public CricketTeam getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(CricketTeam tossWinner) {
        this.tossWinner = tossWinner;
    }

    public CricketTeam getInnint1Team() {
        return innint1Team;
    }

    public void setInnint1Team(CricketTeam innint1Team) {
        this.innint1Team = innint1Team;
    }

    public CricketTeam getCurrentInningTeam() {
        return currentInningTeam;
    }

    public void setCurrentInningTeam(CricketTeam currentInningTeam) {
        this.currentInningTeam = currentInningTeam;
    }

    public String getMatch_id(){return Match_id;}
    public void setMatch_id(String match_id){
        this.Match_id=match_id;
    }

    }


package com.cricket.uma.CricketDB.CricketGame;

import java.util.List;

public class CricketTeam {
    public static class CricketPlayer{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    private String teamId;
    private List<CricketPlayer> players;
    private String teamName;


    public List<CricketPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<CricketPlayer> players) {
        this.players = players;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String id) {
        this.teamId = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

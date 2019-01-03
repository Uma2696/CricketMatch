package com.cricket.uma.CricketDB.CricketGame;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static java.lang.System.out;

public class RunMatch {
    public static void main(String[] args) {
            CricketGame cricketGame = new CricketGame();
            cricketGame.setListener(listener);
            cricketGame.setDbListener(dbListener);
            cricketGame.startGame();

    }

    private static final MatchListener listener = new MatchListener() {
        @Override
        public void teamSetupCompleted(CricketTeam teamA, CricketTeam teamB) {
            out.println("Team Setup completed");
            out.println("Teams: " + teamA.getTeamName() + " " + teamB.getTeamName());
        }

        @Override
        public void tossCompleted(CricketTeam tossWinner) {
            out.println("Toss completed -- outcome = " + tossWinner.getTeamName());
        }

        @Override
        public void inningsCompleted(ScoreBoard inningScoreBoard, CricketGameResult currentResult) {
            out.println(currentResult.getCurrentInningTeam().getTeamName() + "-> innings completed with " + inningScoreBoard.getCurrentTotal());
        }

        public void matchResult(CricketGameResult currentResult, boolean tie) {
            if (tie) {
                out.println("Match Tie");

            } else {
                out.println(currentResult.getWinningTeam().getTeamName() + " won the match");
            }
        }
    };

    private static final DBListener dbListener = new DBListener() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        @Override
        public void updatePlayerRuns(CricketGameResult currentResult, ScoreBoard inningScoreBoard) {


            MongoDatabase database = mongoClient.getDatabase("cricket");
            MongoCollection<Document> match = database.getCollection("team");
            Document d1= new Document("match_id",currentResult.getMatch_id());
            d1.append("teamName",currentResult.getCurrentInningTeam().getTeamName());
            d1.append("overs",inningScoreBoard.getCurrentOver());
            d1.append("wickets",inningScoreBoard.getCurrentWickets());
            d1.append("runs",inningScoreBoard.getCurrentTotal());
            match.insertOne(d1);

        }


    @Override
    public void queryResult(CricketGameResult finalResult) {

        MongoDatabase database = mongoClient.getDatabase("cricket");
        MongoCollection col = database.getCollection("team");
        BasicDBObject query = new BasicDBObject("match_id",finalResult.getMatch_id()).append("teamName",finalResult.getWinningTeam().getTeamName());
        FindIterable<Document> findIterable = col.find(query);
        MongoCursor<Document> data = findIterable.iterator();
        Document dbObject = new Document();
        while(data.hasNext()) {
            dbObject =  data.next();

        }
        System.out.println("result ="+dbObject);
        mongoClient.close();
    }

    };
}

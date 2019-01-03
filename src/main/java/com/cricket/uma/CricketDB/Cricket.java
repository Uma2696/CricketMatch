package com.cricket.uma.CricketDB;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team" )
public class Cricket {

    public ObjectId _id;
    public String runs;
    public String team;
   // public String playerName;


    public Cricket(){

    }

    public Cricket(ObjectId _id,String runs,String playerName,String team) {
        this._id=_id;
        this.runs=runs;
       // this.playerName=playerName;
        this.team=team;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


}



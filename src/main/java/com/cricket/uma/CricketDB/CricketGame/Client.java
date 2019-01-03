package com.cricket.uma.CricketDB.CricketGame;

import com.mongodb.MongoClient;

public class Client extends MongoClient {

    public Client() {
        super();
    }

    public Client(String host, int port) {
        super(host, port);
    }
}

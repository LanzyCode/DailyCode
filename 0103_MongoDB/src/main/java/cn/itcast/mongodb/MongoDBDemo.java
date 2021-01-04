package cn.itcast.mongodb;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.function.Consumer;

public class MongoDBDemo {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://150.158.173.105:27017");
        MongoDatabase testdb = mongoClient.getDatabase("testdb");
        MongoCollection<Document> user = testdb.getCollection("user");
        for (Document document : user.find().limit(10)) {
            System.out.println(document.toJson());
        }
        mongoClient.close();
    }

}


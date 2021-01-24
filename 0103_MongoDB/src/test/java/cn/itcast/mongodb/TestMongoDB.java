package cn.itcast.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.*;

public class TestMongoDB {
    MongoCollection<Document> user;

    @Before
    public void init() {
        MongoClient mongoClient = MongoClients.create("mongodb://150.158.173.105:27017");
        MongoDatabase testdb = mongoClient.getDatabase("testdb");
        user = testdb.getCollection("user");
    }

    @Test
    public void testQuery() {
        // 查询age<=50并且id>=100的用户信息，
        // 并且按照id倒序排序，
        // 只返回id，age字段，
        // 不返回_id字段
        for (Document document : this.user.find(
                and(
                        lte("age", 50),
                        gte("id", 100)
                )
        ).sort(descending("id"))
                .projection(fields(include("id", "age"), excludeId())))
        {
            System.out.println(document.toJson());
        }
    }
    @Test
    public void testInsert(){
        Document document = new Document();
        document.append("id", 9999);
        document.append("username", "张三");
        document.append("age", 23);

        this.user.insertOne(document);
        this.user.find(eq("id",9999)).forEach((Consumer<? super Document>) document1 ->
                System.out.println(document1.toJson())
        );
    }
    @Test
    public void testUpdate(){
        this.user.updateOne(eq("id",9999), Updates.set("age", 35));
        this.user.find(eq("id",9999)).forEach((Consumer<? super Document>) document1 ->
                System.out.println(document1.toJson())
        );
    }
    @Test
    public void testDelete(){
        this.user.deleteMany(eq("id",9999));
        this.user.find(eq("id",9999)).forEach((Consumer<? super Document>) document1 ->
                System.out.println(document1.toJson())
        );
    }
}

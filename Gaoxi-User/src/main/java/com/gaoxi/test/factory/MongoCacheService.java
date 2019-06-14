package com.gaoxi.test.factory;

import com.alibaba.dubbo.common.json.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.IOException;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class MongoCacheService extends AbstractCacheService {

    private MongoClient mongoClient;

    private MongoDatabase mongoDatabase;

    private MongoCollection<Document> collection;

    @Override
    protected void set0(String key, Object val) {
        Document document = null;
        if (val instanceof String) {
            document = new Document("key", key).append("value", val);
        } else {
            try {
                document = new Document("key", key).append("value", JSON.json(val));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       if(collection.count(Filters.eq("key", key))>0) {
           collection.replaceOne(Filters.eq("key", key),document);
       }else{
           collection.insertOne(document);
       }
    }

    @Override
    protected Object get0(String key) {

        return ((FindIterable<Document>)collection.find(new BasicDBObject("key",key))).first().get("value");
    }

    @Override
    protected void init0() {
        try {
            mongoClient = new MongoClient("localhost",27017);
            mongoDatabase = mongoClient.getDatabase("mytest");

            System.out.println("Connect to database successfully");
            collection = mongoDatabase.getCollection("test");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    protected void destroy0() {
        mongoClient.close();
    }
}

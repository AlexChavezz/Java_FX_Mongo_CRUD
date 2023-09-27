package com.example.test;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;


public class Connection {

    public String Connect ( String userToFind ) {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://java_user:java_password@cluster0.cbq1dte.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("users");
            MongoCollection<Document> collection = database.getCollection("users");
            Document doc = collection.find(eq("name", userToFind)).first();
            if (doc != null) {
                System.out.println(doc.toJson());
                return doc.toJson();
            } else {
                System.out.println("No matching documents found.");
                return "User Not Found";
            }
        }
    }

}

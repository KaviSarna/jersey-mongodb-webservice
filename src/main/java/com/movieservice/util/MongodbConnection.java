package com.movieservice.util;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongodbConnection {
	
	public static MongoCollection<Document> getMongoCollection() {
		
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient("localhost", 27017);
		
		MongoDatabase database = client.getDatabase("moviesdb");
		
		MongoCollection<Document> collection = database.getCollection("movies");
		
		return collection;
	}
}
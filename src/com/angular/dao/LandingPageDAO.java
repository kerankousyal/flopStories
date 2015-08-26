package com.angular.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class LandingPageDAO {
	
	private static final int port = 27017;
	private static final String host = "localhost";
	//private static final String host = "www.primeimap.com";
	//private static final String host = "localhost";
	private static MongoClient mongo = null;
	
	public String getAllTopPlayers(int limit) {
		
		List<DBObject> listString = new ArrayList<DBObject>();
		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");
			
				//BasicDBObject whereQuery = new BasicDBObject();
				//whereQuery.put("userstatus", "complete");
				
				DBCollection collection = db.getCollection("users");
				
				DBObject sortFilter = new BasicDBObject("rank", 1);
				
				DBCursor cursor = collection.find().sort(sortFilter).limit(limit);
				  while (cursor.hasNext()) {
					  listString.add(cursor.next());
				  }
				  System.out.println(listString.size());
				  cursor.close();
				  mongo.close();
				  return listString.toString();
	} catch (Exception e) {
		System.out.println(e);
	}
	
		return listString.toString();
	}

	public String getFeaturedStory() {

		
		List<DBObject> listString = new ArrayList<DBObject>();
		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");
			
				//BasicDBObject whereQuery = new BasicDBObject();
				//whereQuery.put("userstatus", "complete");
				
				DBCollection collection = db.getCollection("storydetail");
				
				DBObject filter = new BasicDBObject("_id", -1);
				
				DBCursor cursor = collection.find().sort(filter).limit(1);
				
				  while (cursor.hasNext()) {
					  listString.add(cursor.next());
				  }
				  
				  System.out.println(listString.size());
				  
				  cursor.close();
				  mongo.close();
				  
				  return listString.toString();
				  
	} catch (Exception e) {
		System.out.println(e);
	}
	
		return listString.toString();
	}

}

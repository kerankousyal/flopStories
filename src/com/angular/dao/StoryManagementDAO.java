package com.angular.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.angular.vo.StoryDetail;
import com.angular.vo.UserVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class StoryManagementDAO {

	private static final int port = 27017;
	private static final String host = "localhost";
	private static MongoClient mongo = null;

	public boolean saveStoryDetail(StoryDetail uVO) {

		boolean success = true;

		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");

			DBCollection collection = db.getCollection("storydetail");

			DBObject document = new BasicDBObject();

			document.put("ownername", uVO.getOwnerName());
			document.put("storyname", uVO.getStoryName());
			document.put("shortdescription", uVO.getShortDescription());
			document.put("storycontent", uVO.getStoryContent());
			document.put("category", uVO.getCategory());
			document.put("status", "submitted");
			
			List<BasicDBObject> commentsList = new ArrayList<>();
			
			document.put("comments", commentsList);

			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date today = Calendar.getInstance().getTime();
			String todayDate = df.format(today);

			document.put("createdDate", todayDate);

			collection.insert(document);

			mongo.close();

		} catch (Exception e) {
			success = false;
			System.out.println("User Registration failed!!");
			e.printStackTrace();
		}
		return success;
	}

	public static boolean updateRank() {

		boolean result = true;
		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");

			DBCollection collection = db.getCollection("users");

			BasicDBObject searchQuery = new BasicDBObject();

			searchQuery.put("username", "kkousyal@gmail.com");

			BasicDBObject newDocument = new BasicDBObject();

			newDocument.put("rank", 2);

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			collection.update(searchQuery, updateObj);

			mongo.close();
		} catch (Exception e) {
			result = false;
			System.out.println(e);
		}

		return result;
	}

	public static void main(String[] args) {

		updateRank();
	}

	public String getAllStories() {

		List<DBObject> listString = new ArrayList<DBObject>();
		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");

			DBCollection collection = db.getCollection("storydetail");

			DBObject sortFilter = new BasicDBObject("createdDate", 1);

			DBCursor cursor = collection.find().sort(sortFilter);
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

	public String getUserDetail(String _id) {

		List<DBObject> listString = new ArrayList<DBObject>();

		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");


			DBCollection collection = db.getCollection("storydetail");

			BasicDBObject query = new BasicDBObject();
			query.put("_id", new ObjectId(_id));

			DBCursor cursor = collection.find(query);

			if (cursor.size() > 0)
				listString.add(cursor.next());

			mongo.close();
			return listString.toString();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return listString.toString();
	}
	
	public static boolean saveComments(StoryDetail sDetail) {

		boolean result = true;
		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");

			DBCollection collection = db.getCollection("storydetail");

			BasicDBObject searchQuery = new BasicDBObject();

			searchQuery.put("_id", new ObjectId(sDetail.get_id()));
			
			BasicDBObject commentsObject = new BasicDBObject();
			
			commentsObject.put("comments", sDetail.getComments().get(0).getComments());
			commentsObject.put("commentedUser", sDetail.getComments().get(0).getCommentedUser());
			commentsObject.put("commentedDate", sDetail.getComments().get(0).getCommentedDate());
			
			BasicDBObject newDocument = new BasicDBObject();
			
			newDocument.put("comments", commentsObject);

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$push", newDocument);

			collection.update(searchQuery, updateObj);

			mongo.close();
		} catch (Exception e) {
			result = false;
			System.out.println(e);
		}

		return result;
	}
}

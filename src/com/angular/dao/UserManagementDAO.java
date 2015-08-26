package com.angular.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.angular.helper.DecryptPassword;
import com.angular.vo.CurrentUserSession;
import com.angular.vo.UserVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class UserManagementDAO {

	private static final int port = 27017;
	private static final String host = "localhost";
	private static MongoClient mongo = null;

	public CurrentUserSession validateUser(String username,
			String password) {
			
		CurrentUserSession currentSession = new CurrentUserSession();
		currentSession.setStatus("Invalid username/password!");
			
			try {
				mongo = new MongoClient(host, port);
				DB db = mongo.getDB("flopstories");
				
					DBCollection collection = db.getCollection("users");
					
					BasicDBObject searchQuery = new BasicDBObject();
					searchQuery.put("username", username);
					
					DBCursor cursor = collection.find(searchQuery);
				 
					while (cursor.hasNext()) {
						
						DBObject resultElement = cursor.next();
						String pwd="";

			            if(resultElement.containsField("username")){
			                pwd = (String) resultElement.get("password");
			            	}
					    if(DecryptPassword.validatePassword(password, pwd)) {
					    	
					    	currentSession.setStatus("success");
					    	
					    	UserVO uVO = new UserVO();
					    	
					    	if(null!=resultElement.get("username"))
					    	uVO.setUsername(resultElement.get("username").toString());
					    	
					    	if(null!=resultElement.get("firstname"))
						    	uVO.setFirstname(resultElement.get("firstname").toString());
					    	
					    	if(null!=resultElement.get("lastname"))
						    	uVO.setLastname(resultElement.get("lastname").toString());
					    	
					    	currentSession.setUser(uVO);
					    } else {
					    	currentSession.setStatus("Invalid username/password!");
					    }
								
					}
					
					mongo.close();
					
		} catch (Exception e) {
			System.out.println("User Registration failed!!");
			e.printStackTrace();
		}
			return currentSession;
		}

	
	
public boolean registerUser(UserVO uVO, String encryptedPWD) {
		
		boolean success = true;
		
		try {
			mongo = new MongoClient(host, port);
			DB db = mongo.getDB("flopstories");
			
				DBCollection collection = db.getCollection("users");
				
					DBObject document = new BasicDBObject();
					
					document.put("username", uVO.getUsername());
					document.put("password", encryptedPWD);
					document.put("sQuestion", uVO.getSecurityQuestion());
					document.put("firstname", uVO.getFirstname());
					document.put("lastname", uVO.getLastname());
					document.put("email", uVO.getEmail());
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date today = Calendar.getInstance().getTime();
					String todayDate = df.format(today);
					
					document.put("createdDate",todayDate );
					
				collection.insert(document);
				
				mongo.close();
				
	} catch (Exception e) {
		success=false;
		System.out.println("User Registration failed!!");
		e.printStackTrace();
	}
		return success;
	}


public boolean checkForDuplicateUser(String username) {
		
			boolean success = true;
			
			try {
				mongo = new MongoClient(host, port);
				DB db = mongo.getDB("flopstories");
				
				List<String> filterList = new ArrayList<String>();
				
				filterList.add(username);
				
					DBCollection collection = db.getCollection("users");
					
					BasicDBObject query = new BasicDBObject();
					query.put("username", new BasicDBObject("$in", filterList));
					
					DBCursor cursor = collection.find(query);
					
					if(cursor.size() > 0)
						success=false;
					
					mongo.close();
					
				} catch (Exception e) {
					
					System.out.println("User duplicate check failed!!");
					e.printStackTrace();
				}
			return success;
	
	}



public String getUserDetail(String username) {
	
	List<DBObject> listString = new ArrayList<DBObject>();
	
	try {
		mongo = new MongoClient(host, port);
		DB db = mongo.getDB("flopstories");
		
		List<String> filterList = new ArrayList<String>();
		
		filterList.add(username);
		
			DBCollection collection = db.getCollection("users");
			
			BasicDBObject query = new BasicDBObject();
			query.put("username", new BasicDBObject("$in", filterList));
			
			DBCursor cursor = collection.find(query);
			
			if(cursor.size() > 0)
				 listString.add(cursor.next());
			
			mongo.close();
			return listString.toString();
			
		} catch (Exception e) {
			
			System.out.println("User duplicate check failed!!");
			e.printStackTrace();
		}
	return listString.toString();
}

}

package com.project;

import java.io.FileNotFoundException;
import com.mongodb.*;

public class InputItemDetail {

	String result = "";
	

	public String getItemName(String query) throws FileNotFoundException{
		String[] queryFields = query.split(":");
		if (queryFields.length != 2) {
			return "Invalid Query";
		}
		String name = queryFields[0];
		String store = queryFields[1];
		System.out.println("query: " + query);
		
		//Get result from DB
		String output = getResultFromDB(name,store);
		if (!(output.equalsIgnoreCase("Item Not found")))
			return "Item  " + name + " is located  " + output ;
		else 
			return  "Item " + name +" is not in " + store + " store currently. Aplogies" ;

	}
	
	//Getting results from Mongo database
	public 	String getResultFromDB(String name, String store) throws FileNotFoundException{		
		return result = getObject(name,store);
	}	

	String getObject(String itemName, String storeName)
	{
		Mongo m = null;
		try {
			m = new Mongo( "localhost" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		DB db = m.getDB( "mydb" );
		String isle = "Item Not found";
		DBCollection coll = db.getCollection("testCollection");		
		BasicDBObject query = new BasicDBObject();
		
		//Forming query for ItemName and StoreName 
		query.put("Item", itemName);
		query.put("Store", storeName);
		
		DBCursor cur = coll.find();
		cur = coll.find(query);	
		//System.out.println("cur Value when empty" +cur);
		while(cur.hasNext()) {
			isle = " at isle " + cur.next().get("Isle").toString() + " in " + storeName  ;
		//System.out.println(isle);			
		}
		return new String(isle);
	}
}





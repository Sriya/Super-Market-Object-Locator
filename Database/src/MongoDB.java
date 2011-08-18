
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
//import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

public class MongoDB {
	public static void main(String []args) throws UnknownHostException, MongoException
	{
		Mongo m = new Mongo( "localhost" );
		MongoDB test = new MongoDB();

		DB db = m.getDB( "mydb" );
		DBCollection coll = db.getCollection("testCollection");
		 //test.insert(db);
		//test.removeObject(db);
		Set<String> colls = db.getCollectionNames();

		for (String s : colls) {
			System.out.println(s);
		}
		BasicDBObject query = new BasicDBObject();
		DBCursor cur = coll.find();
		cur = coll.find(query);

		while(cur.hasNext()) {
			System.out.println(cur.next());
		}
	}

	private void insert(DB db) {		
		DBCollection coll = db.getCollection("testCollection");
		
		BasicDBObject doc = new BasicDBObject();
		
		doc.put("Store", "Target");
		doc.put("Item", "Apple");
		doc.put("Item No", "101");
		doc.put("Isle", 10.1);		
		coll.insert(doc);

		doc = new BasicDBObject();
		doc.put("Store", "Target");
		doc.put("Item", "Apple");
		doc.put("Item No", "101");
		doc.put("Isle", 10.1);		
		coll.insert(doc);
		
		doc = new BasicDBObject();
		doc.put("Store", "Target");
		doc.put("Item", "Shampoo");
		doc.put("Item No", "102");
		doc.put("Isle", 10.2);	
		doc.put("Special", "20% off with Conditioner");
		coll.insert(doc);

		doc = new BasicDBObject();
		doc.put("Store", "Target");
		doc.put("Item", "Pears");
		doc.put("Item No", "103");
		doc.put("Isle", 10.3);		
		coll.insert(doc);
		
		doc = new BasicDBObject();
		doc.put("Store", "Target");
		doc.put("Item", "Milk");
		doc.put("Item No", 104);
		doc.put("Isle", 10.4);		
		coll.insert(doc); 
		
		doc = new BasicDBObject();
		doc.put("Store", "Walmart");
		doc.put("Item", "Milk");
		doc.put("Item No", 204);
		doc.put("Isle", 20.4);		
		coll.insert(doc);
		
		doc = new BasicDBObject();
		doc.put("Store", "Walmart");
		doc.put("Item", "Cookie");
		doc.put("Item No", 206);
		doc.put("Isle", 20.6);		
		coll.insert(doc);
		
		
		
		doc = new BasicDBObject();
		doc.put("Store", "Walmart");
		doc.put("Item", "sugar");
		doc.put("Item No", 205);
		doc.put("Isle", 20.5);		
		coll.insert(doc);
		

	}
	
	void deleteDatabase(Mongo m)
	{
		
		m.dropDatabase("mydb");
		
		
	}
	
	void removeObject(DB db)
	{
		DBCollection coll = db.getCollection("testCollection");
		BasicDBObject doc = new BasicDBObject();
		//doc.put("Store", "Target");
		doc.put("Item", getItemName());
		//doc.put("Item No", "101");
		//doc.put("Isle", 10.1);	
		coll.remove(doc);
	}

	private String getItemName(){
		String itemName = null;
		System.out.print("Enter Item Name: ");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader bs = new BufferedReader(is);
		try {
			itemName = bs.readLine();
			System.out.println("itemName !!!!!!!!!!!!!!!!!!:  " + itemName);
			String[] strs = itemName.split(" ");
			System.out.println("strs %%%%%%%%%%%%%%%%%%%%%%%%:" + strs);
			if(strs.length > 1){
				System.out.println("Invalid Entry ! Try again.");
				getItemName();
			}
		} catch (IOException e) {	
			e.printStackTrace();
		}
		return itemName;
	}

}

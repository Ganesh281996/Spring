package mongodbpractice;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Mongoose 
{
	public static void main(String[] args) throws UnknownHostException 
	{
		MongoClient mongoClient=new MongoClient("localhost", 27017);
		DB db=mongoClient.getDB("testpass");
		DBCollection dbCollection=db.getCollection("user");
		BasicDBObject basicDBObject=new BasicDBObject();
		basicDBObject.put("name", "ganesh");
//		dbCollection.insert(basicDBObject);
//		basicDBObject.put("name", "vim");
		BasicDBObject newObject=new BasicDBObject();
		newObject.put("name", "vimlesh");
		dbCollection.remove(newObject);
//		dbCollection.update(basicDBObject, new BasicDBObject("$set", newObject));
		DBCursor dbCursor=dbCollection.find();
		while(dbCursor.hasNext())
		{
			System.out.println(dbCursor.next());
		}
	}
}
package MongoDB;
import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;


public class MongoProcessingUpdate {
    private MongoClient mongoClient;
    public static final String SERVER = "localhost";
    public static final int PORT = 27017;

    public MongoProcessingUpdate() throws UnknownHostException {
        mongoClient = new MongoClient(SERVER, PORT);
    }

    public MongoClient getConnection() {
        return mongoClient;
    }

    
	 public static BasicDBObject createDoc(String title, String year,String  duration,String  natio,String  name,String  age){ 
	    BasicDBObject doc = new BasicDBObject("title", title)
           .append("year", year)
           .append("duration", duration)
		   .append("natio", natio)
           .append("actor", new BasicDBObject("name", name).append("age", age));
         return doc;
	 }
	 
	 public static BasicDBObject updateDoc(String title, String year,String  duration,String  natio,String  name,String  age){ 
		 BasicDBObject doc = new BasicDBObject();
		 BasicDBObject setData = new BasicDBObject();
		 setData.append("year", year)
		           .append("duration", duration)
				   .append("natio", natio)
		           .append("actor", new BasicDBObject("name", name).append("age", age));
		 doc.append("$set", setData);
	     return doc;
		 }
	 
	 
    
    public MongoBeans ProcessUserData(String title, String year,String  duration,String  natio,String  name,String  age)throws UnknownHostException  {
		MongoBeans user = null;
		 
		user = new MongoBeans(title, year, duration, natio, name, age);

	    try {

          MongoDB mongo = new MongoDB();
          DB db = mongo.getConnection().getDB("cinema");
          DBCollection films = db.getCollection("films");
          DBCursor cursor = films.find();
          BasicDBObject searchQuery = new BasicDBObject().append("title", title);
          films.update(searchQuery, updateDoc(title, year, duration, natio, name, age), true, false);
          DBObject film = films.findOne();
          System.out.println(film);

          
          while(cursor.hasNext()) {
              DBObject obj = cursor.next();
              System.out.println(obj.toString());
          }
        } finally {
           //cursor.close();
        }
		
		return user;
	}
}//end of class

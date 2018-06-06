package MongoDB;
import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;


public class MongoProcessingDelete{
    private MongoClient mongoClient;
    public static final String SERVER = "localhost";
    public static final int PORT = 27017;

    public MongoProcessingDelete() throws UnknownHostException {
        mongoClient = new MongoClient(SERVER, PORT);
    }

    public MongoClient getConnection() {
        return mongoClient;
    }

	 public static BasicDBObject deleteDoc(String title){ 
	    BasicDBObject doc = new BasicDBObject("title", title);
	    doc.put("title", title);
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
		  
		  films.remove(deleteDoc(title));

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

package MongoDB;
import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import MongoDB.MongoBeans;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class MongoProcessingSearch {
    private MongoClient mongoClient;
    public static final String SERVER = "localhost";
    public static final int PORT = 27017;

    public MongoProcessingSearch() throws UnknownHostException {
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
	 public static BasicDBObject updateDoc(String title, String year,String  duration,String  natio,String  name,String  age, Integer view){ 
		 BasicDBObject doc = new BasicDBObject();
		 BasicDBObject setData = new BasicDBObject();
		 setData.append("year", year)
		           .append("duration", duration)
				   .append("natio", natio)
		           .append("actor", new BasicDBObject("name", name).append("age", age))
		           .append("view", view);
		 doc.append("$set", setData);
	     return doc;
		 }

    
    public MongoBeans ProcessUserData(String title, String year,String  duration,String  natio,String  name,String  age)throws UnknownHostException  {
		MongoBeans user = null;

	    try {

          MongoDB mongo = new MongoDB();
          DB db = mongo.getConnection().getDB("cinema");
		  
		  
          DBCollection films = db.getCollection("films");
          DBCursor cursor = films.find();
          BasicDBObject searchQuery = new BasicDBObject().append("title", title);
          
          cursor = films.find(searchQuery);
          
          try {
             while(cursor.hasNext()) {
                 System.out.println(cursor.next());
             }
          } finally {
             cursor.close();
          }
          cursor = films.find(searchQuery);
          BasicDBObject object = (BasicDBObject)cursor.next();
          String currentValueTitle = object.getString("title");
          String currentValueYear = object.getString("year");
          String currentValueDuratioon = object.getString("duration");
          String currentValueNation = object.getString("nation");
          String currentValueName = object.getString("name");
          String currentValueAge = object.getString("age");
          Integer currentValueView = 0;
          String currentValueViewTemp = object.getString("view");
         
         
          user = new MongoBeans(currentValueTitle, currentValueYear, currentValueDuratioon, currentValueNation, currentValueName, currentValueAge);
          
         if(currentValueViewTemp != null){	  
        	  currentValueView = Integer.parseInt(currentValueViewTemp) + 1;  
        	  
         }else {
        	  currentValueView = 1;	 
         }
        	  
        
         films.remove(object);
          films.update(searchQuery, updateDoc(currentValueTitle, currentValueYear, currentValueDuratioon, currentValueNation, currentValueName, currentValueAge, currentValueView), true, false);
        
        } finally {
           //cursor.close();
        }
		
		return user;
	}
}//end of class

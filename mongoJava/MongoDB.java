package MongoDB;
import java.net.UnknownHostException;
import com.mongodb.MongoClient;

public class MongoDB {
    private MongoClient mongoClient;
    public static final String SEREVR = "localhost";
    public static final int PORT = 27017;

    public MongoDB() throws UnknownHostException {
        mongoClient = new MongoClient(SEREVR, PORT);
    }

    public MongoClient getConnection() {
        return mongoClient;
    }
}

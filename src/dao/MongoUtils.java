package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.Iterator;
import java.util.Random;

import static utils.Constants.*;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
public class MongoUtils {

    private static MongoClient client;
    static {
        client = new MongoClient(MONGO_HOST, MONGO_PORT);
    }

    static MongoCollection getCollection(Class clazz){
        return getCollection(clazz.getSimpleName());
    }

    public static MongoCollection getIdCollection(Class clazz){
        return getCollection("id_" + clazz.getSimpleName());
    }
    
    private static MongoCollection getCollection(String collectionName){
        DB database = client.getDB(DB_NAME);
        Jongo jongo = new Jongo(database);
        return jongo.getCollection(collectionName);
    }

    static Long generateLongId(Entity entity) {
        MongoCollection collection = getIdCollection(entity.getClass());
        MongoCursor<Id> ids = collection.find().as(Id.class);
        Iterator<Id> iterator = ids.iterator();
        Long previous = new Random().nextLong();
        if (iterator.hasNext()){
            previous = iterator.next().asLong();
            while (iterator.hasNext()){
                Long next = iterator.next().asLong();
                if (previous + 1L != next)
                    break;
                previous = next;
            }
        }
        return previous + 1L;
    }
}

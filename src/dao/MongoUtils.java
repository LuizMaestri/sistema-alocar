package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import exception.IdException;
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
        DB database = client.getDB(DB_NAME);
        Jongo jongo = new Jongo(database);
        return jongo.getCollection(clazz.getSimpleName());
    }

    static MongoCollection getIdCollection(Class clazz){
        DB database = client.getDB(DB_NAME);
        Jongo jongo = new Jongo(database);
        return jongo.getCollection("id_" + clazz.getSimpleName());
    }

    public static Entity id(Entity entity) throws IdException {
        Object id = entity.getId();
        if (id != null && !validateId(entity))
            throw new IdException("Invalid ID");
        if ((id == null) && !entity.getIdClass().equals(String.class)){
            entity = generateLongId(entity);
        }
        return entity;
    }

    private static Entity<Long> generateLongId(Entity entity) {
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
        entity.setId(previous + 1L);
        return entity;
    }

    private static boolean validateId(Entity entity) {
        MongoCollection collection = getIdCollection(entity.getClass());
        MongoCursor ids = collection.find().as(entity.getIdClass());
        Iterator iterator = ids.iterator();
        boolean exist = false;
        while (iterator.hasNext()){
            exist = iterator.next().equals(entity.getId());
            if (exist) break;
        }
        return exist;
    }

}

package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import static utils.Constants.DB_NAME;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
class MongoUtils {

    private static MongoClient client;
    static {
        client = new MongoClient();
    }

    static MongoCollection getCollection(Class clazz){
        DB database = client.getDB(DB_NAME);
        Jongo jongo = new Jongo(database);
        return jongo.getCollection(clazz.getSimpleName());
    }
}

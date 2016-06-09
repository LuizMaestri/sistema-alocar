package dao;

import com.mongodb.WriteResult;
import org.jongo.MongoCursor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
public abstract class Dao<T> {

    private Class<T> clazz;

    protected abstract Class<T> getEntityClass();

    public Dao() {
        clazz = getEntityClass();
    }

    public boolean put(T entity){
        WriteResult result = MongoUtils.getCollection(clazz).save(entity);
        return result.getUpsertedId() != null;
    }

    public boolean putAll(List<T> entities){
        for (T entity: entities) if (!put(entity)) return false;
        return true;
    }

    public T get(Object id){
        return MongoUtils.getCollection(clazz).findOne("{'_id':#}", id).as(clazz);
    }

    public List<T> listAll(){
        MongoCursor<T> cursor = MongoUtils.getCollection(clazz).find().as(clazz);
        ArrayList<T> entities = new ArrayList<T>();
        for (T aCursor : cursor) entities.add(aCursor);
        return entities;
    }

    public void delete(Object id){
        WriteResult result = MongoUtils.getCollection(clazz).remove("{'_id':#}", id);
    }
}

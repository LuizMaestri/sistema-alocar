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
public abstract class Dao<T extends Entity> {

    private Class<T> clazz;

    protected abstract Class<T> getEntityClass();

    public Dao() {
        clazz = getEntityClass();
    }

    public boolean put(Entity entity) {
        if (entity.getIdClass().equals(Long.class))
            entity.setId(MongoUtils.generateLongId(entity));
        WriteResult result = MongoUtils.getCollection(clazz).save(entity);
        boolean put = result.getUpsertedId() != null;
        if (put){
            Id id = new Id();
            id.setId(entity.getId());
            MongoUtils.getIdCollection(clazz).save(id);
        }
        return put;
    }

    public boolean putAll(List<T> entities) {
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
        MongoUtils.getCollection(clazz).remove("{'_id':#}", id);
        MongoUtils.getIdCollection(clazz).remove("{'_id':#}", id);
    }
}

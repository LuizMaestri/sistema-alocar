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

    @SuppressWarnings("unchecked")
    public boolean put(Entity entity) {
        if (entity.getId() == null && entity.getIdClass().equals(Long.class))
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

    public T get(String propertyName, Object property){
        return MongoUtils.getCollection(clazz).findOne(String.format("{'%s':#}", propertyName), property).as(clazz);
    }

    public ArrayList<T> listAll(){
        MongoCursor<T> cursor = MongoUtils.getCollection(clazz).find().as(clazz);
        ArrayList<T> entities = new ArrayList<>();
        for (T aCursor : cursor) entities.add(aCursor);
        return entities;
    }

    public ArrayList<T> list(String propertyName, Object property){
        MongoCursor<T> cursor = MongoUtils.getCollection(clazz).find(String.format("{'%s':#}", propertyName), property).as(clazz);
        ArrayList<T> entities = new ArrayList<>();
        for (T aCursor : cursor) entities.add(aCursor);
        return entities;
    }

    public boolean delete(Object id){
        WriteResult remove = MongoUtils.getCollection(clazz).remove("{'_id':#}", id);
        if (remove != null) remove = MongoUtils.getIdCollection(clazz).remove("{'_id':#}", id);
        return remove != null;
    }
}

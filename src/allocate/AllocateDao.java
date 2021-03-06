package allocate;

import dao.Dao;
import dao.MongoUtils;
import org.jongo.MongoCursor;

/**
 * Created by loja on 05/07/2016.
 */
public class AllocateDao extends Dao<Allocate> {

    private static  AllocateDao dao;
    static {
        dao = new AllocateDao();
    }

    @Override
    protected Class<Allocate> getEntityClass() {
        return Allocate.class;
    }

    public static AllocateDao getDao() {
        return dao;
    }

    public Allocate getLast() {
        MongoCursor<Allocate> cursor = MongoUtils.getCollection(clazz).find().sort("{_id:-1}").limit(1).as(clazz);
        return cursor.hasNext()? cursor.next(): null;
    }
}

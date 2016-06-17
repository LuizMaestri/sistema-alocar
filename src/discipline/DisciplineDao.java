package discipline;

import dao.Dao;
import dao.Id;
import dao.MongoUtils;
import exception.IdException;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class DisciplineDao extends Dao<Discipline>{
    private static DisciplineDao dao;
    static {
        dao = new DisciplineDao();
    }

    @Override
    protected Class<Discipline> getEntityClass() {
        return Discipline.class;
    }

    public static DisciplineDao getDao() {
        return dao;
    }

    public boolean putDicipline(Discipline discipline, boolean insert) throws IdException {
        if (insert){
            MongoCollection idCollection = MongoUtils.getIdCollection(Discipline.class);
            MongoCursor<Id> ids = idCollection.find().as(Id.class);
            while (ids.hasNext()){
                if (ids.next().toString().equals(discipline.getId()))
                    throw new IdException("invalid Id");
            }
        }
        return put(discipline);
    }
}

package discipline;

import dao.Dao;

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
}

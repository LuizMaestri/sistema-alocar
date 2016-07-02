package classes;

import dao.Dao;

/**
 * @author luiz
 * @version 1
 * @since 14/06/16
 */
class ClassesDao extends Dao<Classes> {
    private static ClassesDao dao;
    static{
        dao = new ClassesDao();
    }

    protected Class<Classes> getEntityClass() {
        return Classes.class;
    }

    public static ClassesDao getDao() {
        return dao;
    }
}

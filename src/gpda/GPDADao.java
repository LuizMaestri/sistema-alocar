package gpda;

import dao.Dao;

/**
 * @author luiz
 * @version 1
 * @since 10/06/16
 */
class GPDADao extends Dao<GPDA>{
    private static GPDADao dao;
    static {
        dao = new GPDADao();
    }

    protected Class<GPDA> getEntityClass() {
        return GPDA.class;
    }

    public static GPDADao getDao() {
        return dao;
    }
}

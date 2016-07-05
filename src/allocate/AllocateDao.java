package allocate;

import dao.Dao;

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
        return null;
    }
}

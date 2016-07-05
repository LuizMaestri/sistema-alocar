package allocate;

import dao.Dao;
import service.Service;

/**
 * Created by loja on 05/07/2016.
 */
public class AllocateService extends Service<Allocate, Long>{
    @Override
    protected Dao<Allocate> getDao() {
        return AllocateDao.getDao();
    }

    public Allocate last() {
        return ((AllocateDao)getDao()).getLast();
    }
}

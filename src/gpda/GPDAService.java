package gpda;

import dao.Dao;
import service.Service;

/**
 * @author luiz
 * @version 1
 * @since 10/06/16
 */
public class GPDAService extends Service<GPDA, Long> {
    @Override
    protected Dao<GPDA> getDao() {
        return GPDADao.getDao();
    }
}

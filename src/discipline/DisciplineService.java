package discipline;

import dao.Dao;
import service.Service;


/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class DisciplineService extends Service<Discipline, String> {


    @Override
    protected Dao<Discipline> getDao() {
        return DisciplineDao.getDao();
    }
}

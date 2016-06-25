package classes;

import dao.Dao;
import service.Service;

/**
 * @author luiz
 * @version 1
 * @since 14/06/16
 */
public class ClassesService extends Service<Classes, Long> {

    @Override
    protected Dao<Classes> getDao() {
        return ClassesDao.getDao();
    }
}

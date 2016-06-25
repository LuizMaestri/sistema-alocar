package course;

import dao.Dao;
import service.Service;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class CourseService extends Service<Course, Long> {

    @Override
    protected Dao<Course> getDao() {
        return CourseDao.getDao();
    }
}

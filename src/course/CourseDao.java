package course;

import dao.Dao;

/**
 * @author luiz
 * @version 1
 * @since 08/06/16
 */
public class CourseDao extends Dao<Course> {

    public static CourseDao dao;
    static {
        dao = new CourseDao();
    }

    protected Class<Course> getEntityClass() {
        return Course.class;
    }

    public static CourseDao getDao() {
        return dao;
    }
}

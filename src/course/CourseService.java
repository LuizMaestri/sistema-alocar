package course;

import service.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class CourseService extends Service<Course, Long> {

    @Override
    public void fetch() {
        list = CourseDao.getDao().listAll();
        for (int index=0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    @Override
    public boolean save(Course entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<Course> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {
        if (id != null) CourseDao.getDao().delete(id);
    }
}

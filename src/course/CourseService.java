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

    public CourseService() {
        this.indexes = new HashMap<Long, Integer>();
        this.fetch();
    }

    @Override
    public void fetch() {
        list = CourseDao.getDao().listAll();
        for (int i=0; i < list.size(); i++)
            indexes.put(list.get(i).get_id(), i);
    }

    @Override
    public Course get(Long id) {
        int index = indexes.get(id);
        return list.get(index);
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

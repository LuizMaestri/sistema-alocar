package classes;

import service.Service;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 14/06/16
 */
public class ClassesService extends Service<Classes, Long> {

    @Override
    public void fetch() {
        list = ClassesDao.getDao().listAll();
        for (int index=0; index < list.size(); index++)
            indexes.put(list.get(index).get_id(), index);
    }

    @Override
    public boolean save(Classes entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<Classes> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}

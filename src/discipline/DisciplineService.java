package discipline;

import service.Service;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class DisciplineService extends Service<Discipline, String> {

    @Override
    public void fetch() {
        list = DisciplineDao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    @Override
    public boolean save(Discipline entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<Discipline> entities) {
        return false;
    }

    @Override
    public void delete(String id) {

    }
}

package professor;

import service.Service;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class ProfessorService extends Service<Professor, Long>{

    @Override
    public void fetch() {
        list = ProfessorDao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    @Override
    public boolean save(Professor entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<Professor> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}

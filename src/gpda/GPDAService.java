package gpda;

import service.Service;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 10/06/16
 */
public class GPDAService extends Service<GPDA, Long> {
    @Override
    public void fetch() {
        list = GPDADao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).get_id(), index);
    }

    @Override
    public boolean save(GPDA entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<GPDA> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}

package room;

import service.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class RoomService extends Service<Room, Long> {

    @Override
    public void fetch() {
        list = RoomDao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    @Override
    public boolean save(Room entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<Room> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}

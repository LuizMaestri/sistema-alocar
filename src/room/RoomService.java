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

    public RoomService() {
        indexes = new HashMap<Long, Integer>();
        fetch();
    }

    public void fetch() {
        list = RoomDao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).get_id(), index);
    }

    public boolean save(Room entity) {
        return false;
    }

    public boolean saveAll(List<Room> entities) {
        return false;
    }

    public void delete(Long id) {

    }
}

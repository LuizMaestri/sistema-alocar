package room;

import dao.Dao;
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
    protected Dao<Room> getDao() {
        return null;
    }
}

package room;

import dao.Dao;
import service.Service;

import java.util.ArrayList;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class RoomService extends Service<Room, Long> {

    @Override
    protected Dao<Room> getDao() {
        return RoomDao.getDao();
    }

    public ArrayList<Room> rooms() {
        return ((RoomDao) getDao()).getRooms();
    }

    public  ArrayList<Room> labs(){
        return ((RoomDao) getDao()).getLabs();
    }
}

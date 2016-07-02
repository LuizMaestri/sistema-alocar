package room;

import dao.Dao;

import java.util.ArrayList;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
class RoomDao extends Dao<Room> {

    private static RoomDao dao;
    static {
        dao = new RoomDao();
    }

    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    public static RoomDao getDao() {
        return dao;
    }

    ArrayList<Room> getRooms(){
        return list("lab", false);
    }

    ArrayList<Room> getLabs(){
        return list("lab", true);
    }
}

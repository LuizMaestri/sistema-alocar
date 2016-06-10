package room;

import dao.Dao;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class RoomDao extends Dao<Room> {

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
}

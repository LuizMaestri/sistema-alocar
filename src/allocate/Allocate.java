package allocate;

import dao.Entity;
import room.Room;

import java.util.ArrayList;

/**
 * Created by loja on 05/07/2016.
 */
public class Allocate extends Entity<Long>{

    private ArrayList<Room> rooms;
    private Exception error;

    @Override
    public Class<Long> getIdClass() {
        return Long.class;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }
}

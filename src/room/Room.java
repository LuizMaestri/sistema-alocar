package room;

import utils.DayOfWeek;

import java.util.EnumMap;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Room {
    private long _id;
    private String building;
    private int floor;
    private int number;
    private int capacity;
    private EnumMap<DayOfWeek, Long[]> occupation;

    public Room() {
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public EnumMap<DayOfWeek, Long[]> getOccupation() {
        return occupation;
    }

    public void setOccupation(EnumMap<DayOfWeek, Long[]> occupation) {
        this.occupation = occupation;
    }

    public boolean allocate(DayOfWeek day, int schedule, Long classes){
        Long[] classesIds = occupation.get(day);
        if (schedule > classesIds.length) return false;
        if (classesIds[schedule] != null) return false;
        classesIds[schedule] = classes;
        occupation.put(day, classesIds);
        return true;
    }
}

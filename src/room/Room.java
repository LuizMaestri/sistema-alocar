package room;

import dao.Entity;
import utils.DayOfWeek;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Room extends Entity<Long>{
    private String building;
    private int floor;
    private int number;
    private int capacity;
    private EnumMap<DayOfWeek, Long[]> occupation;

    public Room() {
        occupation = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day: DayOfWeek.values())
            occupation.put(day, new Long[!day.isSaturday()? 14: 5]);
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

    public boolean allocate(DayOfWeek day, ArrayList<Integer> schedule, Long classes){
        Long[] classesIds = occupation.get(day);
        for (Integer hour: schedule)
            if (classesIds[hour] != null) classesIds[hour] = classes;
            else return false;
        return true;
    }

    public Class<Long> getIdClass() {
        return Long.class;
    }
}

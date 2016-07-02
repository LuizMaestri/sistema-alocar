package classes;

import course.Course;
import dao.Entity;
import discipline.Discipline;
import exception.AllocationRoomException;
import professor.Professor;
import room.Room;
import utils.DayOfWeek;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map.Entry;

import static utils.ErrorMessage.ALLOCATE_ROOM;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Classes extends Entity<Long>{
    private Course course;
    private int credits;
    private Discipline discipline;
    private EnumMap<DayOfWeek, ArrayList<Integer>> horary;
    private Professor professor;
    private int capacity;
    private char classNumber;

    public Classes() {
        horary = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day: DayOfWeek.values())
            horary.put(day, new ArrayList<>());
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public EnumMap<DayOfWeek, ArrayList<Integer>> getHorary() {
        return horary;
    }

    public void setHorary(EnumMap<DayOfWeek, ArrayList<Integer>> horary) {
        this.horary = horary;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public char getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(char classNumber) {
        this.classNumber = classNumber;
    }

    public Class<Long> getIdClass() {
        return Long.class;
    }

    public ArrayList<Room> choiceRoom(ArrayList<Room> rooms) throws AllocationRoomException {
        boolean allocate = false;
        ArrayList<Room> choicedRooms = new ArrayList<>();
        for (Entry<DayOfWeek, ArrayList<Integer>> hour: horary.entrySet()){
            for (Room room: rooms){
                allocate = room.allocate(hour.getKey(), hour.getValue(), _id);
                if (allocate) {
                    choicedRooms.add(room);
                    break;
                }
            }
            if (!allocate) throw new AllocationRoomException(ALLOCATE_ROOM, this);
        }
        return choicedRooms;
    }
}

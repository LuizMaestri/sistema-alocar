package classes;

import course.Course;
import dao.Entity;
import discipline.Discipline;
import professor.Professor;
import utils.DayOfWeek;

import java.util.EnumMap;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Classes extends Entity<Long>{
    private Course course;
    private int credits;
    private Discipline discipline;
    private EnumMap<DayOfWeek, Integer> horary;
    private Professor professor;
    private int capacity;
    private char classNumber;

    public Classes() {
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

    public EnumMap<DayOfWeek, Integer> getHorary() {
        return horary;
    }

    public void setHorary(EnumMap<DayOfWeek, Integer> horary) {
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
}

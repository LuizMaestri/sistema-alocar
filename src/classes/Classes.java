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
    private int students;

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

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public Class<Long> getIdClass() {
        return Long.class;
    }
}

package classes;

import course.Course;
import discipline.Discipline;
import professor.Professor;
import utils.DayOfWeek;

import java.util.EnumMap;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class Classes {
    private Long _id;
    private Course course;
    private int credits;
    private Discipline discipline;
    private EnumMap<DayOfWeek, Integer> horary;
    private Professor professor;
    private int students;

    public Classes() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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
}

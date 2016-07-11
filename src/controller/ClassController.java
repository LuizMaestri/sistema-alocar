package controller;

import classes.Classes;
import classes.ClassesService;
import course.Course;
import course.CourseService;
import course.Turn;
import discipline.Discipline;
import discipline.DisciplineService;
import exception.InvalidParamsException;
import utils.DayOfWeek;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Created by fabio on 25/06/16.
 */
public class ClassController implements IController {

    private CourseService courseService;
    private DisciplineService disciplineService;
    private ClassesService classService;

    public ClassController() {
        loadData();
    }

    @Override
    public void loadData() {
        this.courseService = new CourseService();
        this.disciplineService = new DisciplineService();
        this.classService = new ClassesService();
    }

    public List<Classes> listClasses() {
        return classService.getList();
    }

    public ArrayList<Discipline> listDisciplines() {
         return disciplineService.getList();
    }

    public ArrayList<Course> listCourses() {
        return courseService.getList();
    }

    public void save(Course course, Discipline discipline, int capacity, int credits, int numClass, EnumMap<DayOfWeek, ArrayList<Integer>> horary) throws InvalidParamsException {
        ArrayList<Classes> classes = new ArrayList<>();
        if (capacity == 0 || credits == 0 || numClass == 0 || discipline == null ||
                course == null || horary == null || horary.isEmpty())
            throw new InvalidParamsException("Todos os campos são obrigatórios.");
        int size = 0;
        for (Entry<DayOfWeek, ArrayList<Integer>> day: horary.entrySet())
            for (Integer hour: day.getValue()){
                if (!Turn.NIGTLY.isHour(hour))
                    throw new InvalidParamsException("Verifique os horários selecionados.");
                size++;
            }
        if (size != 0)
            throw new InvalidParamsException(
                    "Os horários da aula não combinam com a quantidade de créditos da mesma."
            );
        for (int i = 0; i < numClass; i++) {
            Classes newClass = new Classes();
            newClass.setCourse(course);
            newClass.setDiscipline(discipline);
            newClass.setCredits(credits);
            newClass.setCapacity(capacity);
            newClass.setClassNumber((char) (i + 65));
            classes.add(newClass);
        }
        classService.saveAll(classes);
    }

    public void update(Classes classes, int capacity, int credits) throws InvalidParamsException {
        if (capacity == 0 || credits == 0)
            throw new InvalidParamsException("Todos os campos são obrigatórios.");
        classes.setCredits(credits);
        classes.setCapacity(capacity);
        classService.save(classes);
    }


    public void delete(Long id) {
        classService.delete(id);
    }
}
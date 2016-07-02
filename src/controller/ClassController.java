package controller;

import classes.Classes;
import classes.ClassesService;
import discipline.Discipline;
import discipline.DisciplineService;
import exception.InvalidParamsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 25/06/16.
 */
public class ClassController implements IController {

    private DisciplineService disciplineService;
    private ClassesService classService;

    public ClassController() {
        loadData();
    }

    @Override
    public void loadData() {
        this.disciplineService = new DisciplineService();
        this.classService = new ClassesService();
    }

    public List<Classes> listClasses() {
        return classService.getList();
    }

    public ArrayList<Discipline> listDisciplines() {
         return disciplineService.getList();
    }

    public void save(int capacity, Discipline discipline, int credits, int numClass) throws InvalidParamsException {
        ArrayList<Classes> classes = new ArrayList<>();
        if (capacity == 0 || credits == 0 || numClass == 0)
            throw new InvalidParamsException("");
        for (int i = 0; i < numClass; i++) {
            Classes newClass = new Classes();
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
            throw new InvalidParamsException("");
        classes.setCredits(credits);
        classes.setCapacity(capacity);
        classService.save(classes);
    }


    public void delete(Long id) {
        classService.delete(id);
    }
}
package controller;

import classes.Classes;
import classes.ClassesService;
import discipline.Discipline;
import discipline.DisciplineService;

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

    public List<Discipline> listDisciplines() {
         return disciplineService.getList();
    }

    public void save(int capacity, Discipline discipline, int credits, int numClass) {
        ArrayList<Classes> classes = new ArrayList<>();
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


}
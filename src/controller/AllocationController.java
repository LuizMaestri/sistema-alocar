package controller;

import classes.Classes;
import classes.ClassesService;
import discipline.Discipline;
import discipline.DisciplineService;
import exception.AllocationProfessorException;
import gpda.GPDA;
import gpda.GPDAService;
import professor.Professor;
import professor.ProfessorService;
import room.Room;
import room.RoomService;

import java.util.ArrayList;
import java.util.List;
import static utils.ErrorMessage.ALLOCATE_PROFESSOR;

/**
 * @author luiz
 * @version 1
 * @since 25/06/16
 */
public class AllocationController implements IController {

    private ClassesService classesService;
    private GPDAService gpdaService;
    private RoomService roomService;
    private ProfessorService professorService;
    private DisciplineService disciplineService;
    private ArrayList<Professor> professors;
    private ArrayList<Room> rooms;
    private ArrayList<Classes> classes;
    private ArrayList<GPDA> gpdas;


    public AllocationController() {
        loadData();
    }

    @Override
    public void loadData() {
        classesService = new ClassesService();
        gpdaService = new GPDAService();
        roomService = new RoomService();
        professorService = new ProfessorService();
        disciplineService = new DisciplineService();
        professors = new ArrayList<>();
        rooms = new ArrayList<>();
        classes = new ArrayList<>();
        gpdas = new ArrayList<>();
    }

    public void allocateClasses() throws AllocationProfessorException {
        choiceProfessor();
        choiceRoom();
        classesService.saveAll(classes);
        professorService.saveAll(professors);
        roomService.saveAll(rooms);
        gpdaService.saveAll(gpdas);
    }

    private void choiceRoom() {

    }

    private void choiceProfessor() throws AllocationProfessorException {
        List<Classes> classesList = classesService.getList();
        for (Classes classes: classesList){
            Discipline disciplineClass = classes.getDiscipline();
            GPDA gpda = gpdaService.getByDiscipline(disciplineClass);
            ArrayList<Professor> professorList = gpda.getProfessors();
            Professor choiceProfessor = null;
            for (Professor professor: professorList){
                if (!professor.hasMin()){
                    choiceProfessor = professor;
                    break;
                }
            }
            if (choiceProfessor == null){
                for (Professor professor: professorList){
                    if (!professor.hasMax()){
                        choiceProfessor = professor;
                        break;
                    }
                }
            }
            if (choiceProfessor == null)
                throw new AllocationProfessorException(ALLOCATE_PROFESSOR, classes);
            if (choiceProfessor.checkFreeTime(classes)){
                classes.setProfessor(choiceProfessor);
                addToSaveProfessor(choiceProfessor);
                addToSaveGPDA(gpda);
            }
        }
    }

    private void addToSaveGPDA(GPDA gpda) {
        GPDA change = null;
        for (int index = 0; index < gpdas.size(); index++){
            if (gpdas.get(index).getId().equals(gpda.getId())){
                change = gpdas.set(index, gpda);
                break;
            }
        }
        if (change == null) gpdas.add(gpda);
    }

    private void addToSaveProfessor(Professor professor) {
        gpdaService.attProfessor(professor);
        Professor change = null;
        for (int index = 0; index < professors.size(); index++){
            if (professors.get(index).getId().equals(professor.getId())){
                change = professors.set(index, professor);
                break;
            }
        }
        if (change == null) professors.add(professor);
    }

}

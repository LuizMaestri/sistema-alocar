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
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;

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
    private ArrayList<Professor> professors;
    private ArrayList<Room> rooms;
    private ArrayList<Classes> classes;
    private ArrayList<GPDA> gpdas;

    private enum Category{
        SMALL(null, 20),
        MEDIUM(21, 35),
        BIG(36, null);

        Integer min, max;

        Category(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        static Category isCategory(int size){
            for (Category category: values())
                if (category.thisCategory(size))
                    return category;
            return BIG;
        }

        private boolean thisCategory(int size){
            return (min == null || min < size) && (max == null || max > size);
        }
    }


    public AllocationController() {
        loadData();
    }

    @Override
    public void loadData() {
        classesService = new ClassesService();
        gpdaService = new GPDAService();
        roomService = new RoomService();
        professorService = new ProfessorService();
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

    private void choiceProfessor() throws AllocationProfessorException {
        List<Classes> classesList = classesService.getList();
        for (Classes classes: classesList) {
            Discipline disciplineClass = classes.getDiscipline();
            GPDA gpda = gpdaService.getByDiscipline(disciplineClass);
            ArrayList<Professor> professorList = gpda.getProfessors();
            int minIndex = 0,
            maxIndex = 0;
            while (classes.getProfessor() == null) {
                Professor choiceProfessor = null;
                minIndex = selectedMinWorkLoad(minIndex, professorList);
                if (minIndex != -1)
                    choiceProfessor = professorList.get(minIndex);
                if (choiceProfessor == null) {
                    maxIndex = selectedMaxWorkLoad(maxIndex, professorList);
                    if (maxIndex != -1)
                        choiceProfessor = professorList.get(maxIndex);
                }
                if (choiceProfessor == null)
                    throw new AllocationProfessorException(ALLOCATE_PROFESSOR, classes);
                if (choiceProfessor.checkFreeTime(classes)) {
                    classes.setProfessor(choiceProfessor);
                    addToSaveProfessor(choiceProfessor);
                    addToSaveGPDA(gpda);
                }
                minIndex++;
                maxIndex++;
            }
        }
    }


    private int selectedMinWorkLoad(int minIndex, ArrayList<Professor> professorList){
        for (int index = minIndex; index > professorList.size(); index ++) {
            Professor professor = professorList.get(index);
            if (!professor.hasMin()) {
                return minIndex;
            }
        }
        return -1;
    }

    private int selectedMaxWorkLoad(int maxIndex, ArrayList<Professor> professorList){
        for (int index = maxIndex; index > professorList.size(); index ++) {
            Professor professor = professorList.get(index);
            if (!professor.hasMin()) {
                return maxIndex;
            }
        }
        return -1;
    }


    private void choiceRoom() {
        List<Classes> classesList = classesService.getList();
        List<Room> roomList = roomService.getList();
        EnumMap<Category, ArrayList<Classes>> classesMap = classesBySize(classesList);
        EnumMap<Category, ArrayList<Room>> roomMap = roomsBySize(roomList);
        for (Entry<Category, ArrayList<Classes>> entry: classesMap.entrySet()){
            for (Classes classes: entry.getValue()){
                ArrayList<Room> rooms = roomMap.get(entry.getKey());
                rooms = classes.choiceRoom(rooms);
                if (!rooms.isEmpty()){
                    addToSaveClasses(classes);
                    addToSaveRoom(rooms);
                }
            }
        }
    }

    private EnumMap<Category, ArrayList<Classes>> classesBySize(List<Classes> classesList) {
        EnumMap<Category, ArrayList<Classes>> classesBySize = new EnumMap<>(Category.class);
        for (Classes classes: classesList){
            Category category = Category.isCategory(classes.getCapacity());
            ArrayList<Classes> classesFromCategory = classesBySize.get(category);
            if (classesFromCategory == null) classesFromCategory = new ArrayList<>();
            classesFromCategory.add(classes);
            classesBySize.put(category, classesFromCategory);
        }
        return classesBySize;
    }

    private EnumMap<Category,ArrayList<Room>> roomsBySize(List<Room> roomList) {
        EnumMap<Category, ArrayList<Room>> roomsBySize = new EnumMap<>(Category.class);
        for (Room room: roomList){
            Category category = Category.isCategory(room.getCapacity());
            ArrayList<Room> roomsFromCategory = roomsBySize.get(category);
            if (roomsFromCategory == null) roomsFromCategory = new ArrayList<>();
            roomsFromCategory.add(room);
            roomsBySize.put(category, roomsFromCategory);
        }
        return roomsBySize;
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
        gpdaService.updateList(gpda);
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

    private void addToSaveClasses(Classes classes) {
        //TODO add classes on list for save after
    }


    private void addToSaveRoom(ArrayList<Room> rooms) {
        //TODO add rooms on list for save after
    }

}

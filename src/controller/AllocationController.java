package controller;

import allocate.Allocate;
import allocate.AllocateService;
import classes.Classes;
import classes.ClassesService;
import discipline.Discipline;
import exception.AllocationProfessorException;
import exception.AllocationRoomException;
import gpda.GPDA;
import gpda.GPDAService;
import professor.Professor;
import room.Room;
import room.RoomService;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import static utils.ErrorMessage.ALLOCATE_PROFESSOR;
import static utils.Constants.CONTROLLER;

/**
 * @author luiz
 * @version 1
 * @since 25/06/16
 */
public class AllocationController implements IController {

    private ClassesService classesService;
    private GPDAService gpdaService;
    private RoomService roomService;
    private AllocateService allocateService;
    private HashMap<Long, Professor> professors;
    private HashMap<Long, Room> rooms;
    private ArrayList<Classes> classes;
    private HashMap<Long, GPDA> gpdas;

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
        allocateService = new AllocateService();
        CONTROLLER.getUserService().fetch();
        professors = new HashMap<>();
        rooms = new HashMap<>();
        classes = new ArrayList<>();
        gpdas = new HashMap<>();
    }

    public void allocateClasses() throws AllocationProfessorException, AllocationRoomException {
        Allocate allocate = new Allocate();
        try {
            choiceProfessor();
            choiceRoom();
            save();
        } catch (AllocationProfessorException | AllocationRoomException e){
            allocate.setError(e);
            allocateService.save(allocate);
            throw e;
        }
        allocate.setRooms(roomService.rooms());
        allocateService.save(allocate);
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
                if (minIndex != -1) {
                    choiceProfessor = professorList.get(minIndex);
                    minIndex++;
                }
                else minIndex = professorList.size();
                if (choiceProfessor == null) {
                    maxIndex = selectedMaxWorkLoad(maxIndex, professorList);
                    if (maxIndex != -1) {
                        choiceProfessor = professorList.get(maxIndex);
                        maxIndex++;
                    }
                    else throw new AllocationProfessorException(ALLOCATE_PROFESSOR, classes);
                }
                if (choiceProfessor.checkFreeTime(classes)) {
                    classes.setProfessor(choiceProfessor);
                    gpdaService.attProfessor(choiceProfessor);
                    addToSaveProfessor(choiceProfessor);
                    addToSaveGPDA(gpda);
                }
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


    private void choiceRoom() throws AllocationRoomException {
        List<Classes> classesList = classesService.getList();
        List<Room> roomList = roomService.rooms();
        EnumMap<Category, ArrayList<Classes>> classesMap = classesBySize(classesList);
        EnumMap<Category, ArrayList<Room>> roomMap = roomsBySize(roomList);
        for (Entry<Category, ArrayList<Classes>> entry: classesMap.entrySet()){
            for (Classes classes: entry.getValue()){
                ArrayList<Room> rooms = roomMap.get(entry.getKey());
                rooms = classes.choiceRoom(rooms);
                if (!rooms.isEmpty()){
                    addToSaveClasses(classes);
                    addToSaveRooms(rooms);
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
        gpdas.put(gpda.getId(), gpda);
        gpdaService.updateList(gpda);
    }

    private void addToSaveProfessor(Professor professor) {
        professors.put(professor.getId(), professor);
    }

    private void addToSaveClasses(Classes classes) {
        this.classes.add(classes);
    }


    private void addToSaveRooms(ArrayList<Room> rooms) {
        rooms.forEach(room -> {
            this.rooms.put(room.getId(), room);
            roomService.updateList(room);
        });
    }

    private void save(){
        classesService.saveAll(classes);
        CONTROLLER.getUserService().saveAll(new ArrayList<>(professors.values()));
        roomService.saveAll(new ArrayList<>(rooms.values()));
        gpdaService.saveAll(new ArrayList<>(gpdas.values()));
    }

    public Allocate getInfos(){
        return allocateService.last();
    }
}

package controller;

import classes.Classes;
import classes.ClassesService;
import exception.InvalidParamsException;
import labs.LabsRequest;
import labs.LabsRequestService;
import room.Room;
import room.RoomService;
import utils.Constants;
import utils.DayOfWeek;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.*;
import static utils.Constants.CONTROLLER;
import static utils.ErrorMessage.INVALIDA_REQUEST;

/**
 * @author luiz
 * @version 1
 * @since 02/07/16
 */
public class RequestCheckController implements IController {

    private LabsRequestService labService;
    private ClassesService classesService;
    private RoomService roomService;

    public RequestCheckController() {
        loadData();
    }

    @Override
    public void loadData() {
        labService = new LabsRequestService();
        classesService = new ClassesService();
        roomService = new RoomService();
    }

    public List<LabsRequest> listRequests(){
        return labService.listToApproved();
    }

    public void approveReprove(boolean approve, LabsRequest request){
        request.setDeleted(!approve);
        request.setApproved(approve);
        labService.save(request);
    }

    public ArrayList<Classes> getClasses(){
        return classesService.getList().stream()
                .filter(classes -> classes.getProfessor() != null && classes.getProfessor().equals(CONTROLLER.getLoggedUser()))
                .map(Classes::new).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Room> getLabs(){
        return roomService.labs();
    }

    public void save(String start, String finish, Object lab, Object classes, ArrayList<Integer> days) throws InvalidParamsException {
        if (start == null || start.length() != 10 || finish == null ||
                finish.length() != 10 || lab == null || classes == null || days.isEmpty())
            throw new InvalidParamsException(INVALIDA_REQUEST);
        String[] startDate =  start.split("/");
        String[] finishDate = finish.split("/");
        int startMonth = Integer.parseInt(startDate[0]);
        int finishMonth = Integer.parseInt(finishDate[0]);
        boolean sameMonth = startMonth == finishMonth;
        boolean validDate = validDate(startDate) && validDate(finishDate) &&
                (startMonth < finishMonth) ||
                (sameMonth && Integer.parseInt(startDate[1]) < Integer.parseInt(finishDate[1]));
        if (!validDate) throw new InvalidParamsException(INVALIDA_REQUEST);
        LabsRequest request = new LabsRequest();
        request.setClasses((Classes) classes);
        request.setLabs((Room) lab);
        ArrayList<String> dates = new ArrayList<>();
        dates.add(start);
        dates.add(finish);
        request.setDate(dates);
        ArrayList<DayOfWeek> week = new ArrayList<>();
        for (DayOfWeek day: DayOfWeek.values()) if (days.contains(day.ordinal())) week.add(day);
        request.setDays(week);
        request.setFixed(!sameMonth && (finishMonth - startMonth) % 4 == 0);
        labService.save(request);
    }

    private boolean validDate(String[] date) {
        int day = Integer.parseInt(date[1]);
        switch (Integer.parseInt(date[0])){
            case 1 : return day > 0 && day < 32;
            case 2 : {
                boolean leap = new GregorianCalendar().isLeapYear(getInstance().get(YEAR));
                return day > 0 && (!leap && day < 29 || leap && day < 30);
            }
            case 3 : return day > 0 && day < 32;
            case 4 : return day > 0 && day < 31;
            case 5 : return day > 0 && day < 32;
            case 6 : return day > 0 && day < 31;
            case 7 : return day > 0 && day < 32;
            case 8 : return day > 0 && day < 32;
            case 9 : return day > 0 && day < 31;
            case 10 : return day > 0 && day < 32;
            case 11 : return day > 0 && day < 31;
            case 12 : return day > 0 && day < 32;
            default: return false;
        }
    }
}

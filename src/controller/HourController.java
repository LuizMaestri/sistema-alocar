package controller;

import static utils.Constants.CONTROLLER;

import java.util.ArrayList;
import java.util.EnumMap;

import professor.Professor;
import professor.ProfessorService;
import utils.DayOfWeek;

public class HourController implements IController {

	public HourController() {
	}

	@Override
	public void loadData() {
	}

	public void updateFreeTime(EnumMap<DayOfWeek, ArrayList<Integer>> freeTime) {
		Professor professor = CONTROLLER.getLoggedUser();
		professor.setFreeTime(freeTime);
		boolean save = CONTROLLER.getUserService().save(professor);
		if (save)
			CONTROLLER.setLoggedUser(professor);
	}

}

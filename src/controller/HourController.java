package controller;

import static utils.Constants.CONTROLLER;

import java.util.ArrayList;
import java.util.EnumMap;

import professor.Professor;
import professor.ProfessorService;
import utils.DayOfWeek;

public class HourController implements IController {
	private ProfessorService professorService;

	public HourController() {
		loadData();
	}

	@Override
	public void loadData() {
		this.professorService = new ProfessorService();
	}

	public void updateFreeTime(EnumMap<DayOfWeek, ArrayList<Integer>> freeTime) {
		Professor professor = CONTROLLER.getLoggedUser();
		professor.setFreeTime(freeTime);
		boolean save = professorService.save(professor);
		if (save)
			CONTROLLER.setLoggedUser(professor);
	}

}

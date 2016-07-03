package controller;

import static utils.Constants.CONTROLLER;
import static utils.Constants.MAXIMUM_WORKLOAD;
import static utils.ErrorMessage.HOUR_INSUFFICIENT;

import java.util.ArrayList;
import java.util.EnumMap;

import exception.InvalidParamsException;
import professor.Professor;
import utils.DayOfWeek;

public class HourController implements IController {

	public HourController() {
	}

	@Override
	public void loadData() {
	}

	public void updateFreeTime(EnumMap<DayOfWeek, ArrayList<Integer>> freeTime) throws InvalidParamsException {
		Professor professor = CONTROLLER.getLoggedUser();
		if(!hasMin(freeTime, professor)){
			int free = MAXIMUM_WORKLOAD - professor.getAdm() - professor.getExtension() - professor.getResearch();
			throw new InvalidParamsException(String.format(HOUR_INSUFFICIENT, free));
		}
		professor.setFreeTime(freeTime);
		if (CONTROLLER.getUserService().save(professor))
			CONTROLLER.setLoggedUser(professor);
	}

	@SuppressWarnings("unused")
	private boolean hasMin(EnumMap<DayOfWeek, ArrayList<Integer>> freeTime, Professor professor) {
		int freeCount = 0;
		for(ArrayList<Integer> hours: freeTime.values())
			for (Integer integer : hours)
				freeCount++;
		return (MAXIMUM_WORKLOAD - professor.getAdm() - professor.getExtension() - professor.getResearch()) == freeCount;
	}

}

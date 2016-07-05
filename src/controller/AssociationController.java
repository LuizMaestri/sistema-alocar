package controller;

import gpda.GPDAService;
import professor.Professor;

import java.util.ArrayList;
import java.util.List;

import static utils.Constants.CONTROLLER;

/**
 * Created by Luiz on 02/07/2016.
 */
public class AssociationController implements IController{

    private GPDAService gpdaService;

    public AssociationController() {
        loadData();
    }

    @Override
    public void loadData() {
        CONTROLLER.getUserService().fetch();
        gpdaService = new GPDAService();
    }

    public List<Professor> getGpdaProfessors(){
       return gpdaService.getByCoordinator(CONTROLLER.getLoggedUser()).getProfessors();
    }

    public ArrayList<Professor> getProfessor(){
        ArrayList<Professor> professors = CONTROLLER.getUserService().getList();
        professors.removeAll(getGpdaProfessors());
        return professors;
    }
}

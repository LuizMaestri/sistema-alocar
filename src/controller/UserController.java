package controller;

import professor.Professor;
import professor.ProfessorService;

/**
 * Created by fabio on 20/06/16.
 */
public class UserController implements IController {

    Professor loggedUser;
    ProfessorService userService;
    IController current;

    public UserController() {
    	loadData();
    }

    public boolean login(Long user, String pass){
        Professor toAuth = new Professor();
        toAuth.setId(user);
        toAuth.setPassword(pass);
        loggedUser = userService.auth(toAuth);
        return loggedUser != null;
    }

    public void Logout(){

    }

    public Professor getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Professor loggedUser) {
        this.loggedUser = loggedUser;
    }

    public ProfessorService getUserService() {
        return userService;
    }

    public void setUserService(ProfessorService userService) {
        this.userService = userService;
    }

    public IController getCurrent() {
        return current;
    }

    public void setCurrent(IController current) {
        this.current = current;
    }


    @Override
    public void loadData() {
        this.loggedUser = new Professor();
        this.userService = new ProfessorService();
    }
}

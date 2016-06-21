package controller;

import exception.InvalidLoginException;
import exception.InvalidParamsException;
import exception.NotExistException;
import professor.Professor;
import professor.ProfessorService;

/**
 * @author fabio
 * @version 1
 * @since 20/06/16
 */
public class UserController implements IController {

    private Professor loggedUser;
    private ProfessorService userService;
    private IController current;

    public UserController() {
    	loadData();
    }

    public void login(Long user, String pass) throws InvalidLoginException, NotExistException, InvalidParamsException {
        if (user == null || pass == null)
            throw new InvalidParamsException("");
        loggedUser.setId(user);
        loggedUser.setPassword(pass);
        loggedUser = userService.auth(loggedUser);
    }

    public void Logout(){
        loggedUser = new Professor();
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

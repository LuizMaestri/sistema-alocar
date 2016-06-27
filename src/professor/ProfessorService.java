package professor;

import dao.Dao;
import exception.InvalidLoginException;
import exception.NotExistException;
import service.Service;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class ProfessorService extends Service<Professor, Long>{

    @Override
    protected Dao<Professor> getDao() {
        return ProfessorDao.getDao();
    }

    public Professor auth(Professor toAuth) throws InvalidLoginException, NotExistException {
        Long id = toAuth.getId();
        String password = toAuth.getPassword();
        Professor validate = get(id);
        if (validate != null){
            if (validate.getPassword().equals(password)){
                return validate;
            }
            throw new InvalidLoginException("");
        }
        throw new NotExistException("");
    }
}

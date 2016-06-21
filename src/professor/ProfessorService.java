package professor;

import exception.InvalidLogin;
import exception.NotExist;
import service.Service;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
public class ProfessorService extends Service<Professor, Long>{

    @Override
    public void fetch() {
        list = ProfessorDao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    @Override
    public boolean save(Professor entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<Professor> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    public Professor auth(Professor toAuth) throws InvalidLogin, NotExist {
        Long id = toAuth.getId();
        String password = toAuth.getPassword();
        Professor validate = ProfessorDao.getDao().get(id);
        if (validate != null){
            if (validate.getPassword().equals(password)){
                return validate;
            }
            throw new InvalidLogin("");
        }
        throw new NotExist("");
    }
}

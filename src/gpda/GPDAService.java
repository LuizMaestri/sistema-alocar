package gpda;

import dao.Dao;
import discipline.Discipline;
import professor.Professor;
import service.Service;

/**
 * @author luiz
 * @version 1
 * @since 10/06/16
 */
public class GPDAService extends Service<GPDA, Long> {

    @Override
    protected Dao<GPDA> getDao() {
        return GPDADao.getDao();
    }

    public GPDA getByDiscipline(Discipline discipline){
        for (GPDA gpda: list)
            if (gpda.hasDiscipline(discipline))
                return gpda;
        return null;
    }

    public void attProfessor(Professor professor) {
        for (GPDA gpda: list) gpda.updateProfessor(professor);
    }

    public GPDA getByCoordinator(Professor loggedUser) {
        for (GPDA gpda: list)
            if (gpda.getCoordinator().equals(loggedUser))
                return gpda;
        return null;
    }
}

package professor;

import dao.Dao;

/**
 * @author luiz
 * @version 1
 * @since 09/06/16
 */
class ProfessorDao extends Dao<Professor> {
    private static ProfessorDao dao;
    static {
        dao = new ProfessorDao();
    }

    @Override
    protected Class<Professor> getEntityClass() {
        return Professor.class;
    }

    public static ProfessorDao getDao() {
        return dao;
    }
}

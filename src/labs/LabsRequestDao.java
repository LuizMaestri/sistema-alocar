package labs;

import dao.Dao;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public class LabsRequestDao extends Dao<LabsRequest> {
    private static LabsRequestDao dao;
    static{
        dao = new LabsRequestDao();
    }

    protected Class<LabsRequest> getEntityClass() {
        return LabsRequest.class;
    }

    public static LabsRequestDao getDao() {
        return dao;
    }
}

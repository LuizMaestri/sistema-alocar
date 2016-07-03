package labs;

import dao.Dao;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
class LabsRequestDao extends Dao<LabsRequest> {
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

    public List<LabsRequest> listRequest(){
        return list(new String[]{"approved", "deleted"}, new Object[]{false, false});
    }
}

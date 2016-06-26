package labs;

import dao.Dao;
import service.Service;


/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public class LabsRequestService extends Service<LabsRequest, Long> {

    @Override
    protected Dao<LabsRequest> getDao() {
        return LabsRequestDao.getDao();
    }
}

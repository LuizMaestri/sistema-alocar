package labs;

import dao.Dao;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<LabsRequest> listToApproved(){
        return ((LabsRequestDao) getDao()).listRequest();
    }
}

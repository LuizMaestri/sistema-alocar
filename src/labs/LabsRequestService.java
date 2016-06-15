package labs;

import service.Service;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 15/06/16
 */
public class LabsRequestService extends Service<LabsRequest, Long> {

    @Override
    public void fetch() {
        list = LabsRequestDao.getDao().listAll();
        for (int index = 0; index < list.size(); index++)
            indexes.put(list.get(index).getId(), index);
    }

    @Override
    public boolean save(LabsRequest entity) {
        return false;
    }

    @Override
    public boolean saveAll(List<LabsRequest> entities) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}

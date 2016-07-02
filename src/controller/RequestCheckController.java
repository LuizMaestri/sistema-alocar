package controller;

import labs.LabsRequest;
import labs.LabsRequestService;

import java.util.List;

/**
 * Created by loja on 02/07/2016.
 */
public class RequestCheckController implements IController {

    private LabsRequestService labService;

    public RequestCheckController() {
        loadData();
    }

    @Override
    public void loadData() {
        labService = new LabsRequestService();
    }

    public List<LabsRequest> listRequests(){
        return labService.getList();
    }
}

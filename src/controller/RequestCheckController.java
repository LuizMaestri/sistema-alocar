package controller;

import labs.LabsRequest;
import labs.LabsRequestService;

import java.util.List;

/**
 * @author luiz
 * @version 1
 * @since 02/07/16
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
        return labService.listToApproved();
    }

    public void approveReprove(boolean approve, LabsRequest request){
        request.setDeleted(!approve);
        request.setApproved(approve);
        labService.save(request);
    }
}

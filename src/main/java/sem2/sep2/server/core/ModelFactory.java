package sem2.sep2.server.core;


import sem2.sep2.server.model.ManageRoomModel.ManageRoomModel;
import sem2.sep2.server.model.ManageRoomModel.ManageRoomModelImpl;
import sem2.sep2.server.model.managerLoginModel.ManagerLoginModel;
import sem2.sep2.server.model.managerLoginModel.ManagerLoginModelImpl;

public class ModelFactory {
    private ManagerLoginModel loginModel;
    private ManageRoomModel manageRoomModel;
    public ManagerLoginModel getLoginModel() {
        if (loginModel ==null){
            loginModel =new ManagerLoginModelImpl();
        }
        return loginModel;
    }


    public ManageRoomModel getManageRoomModel() {
        if (manageRoomModel ==null){
            manageRoomModel =new ManageRoomModelImpl();
        }
        return manageRoomModel;
    }
}

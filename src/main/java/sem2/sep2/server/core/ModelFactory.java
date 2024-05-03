package sem2.sep2.server.core;


import sem2.sep2.server.model.AdminModel;
import sem2.sep2.server.model.AdminModelImpl;

public class ModelFactory {
    private AdminModelImpl adminModelImpl;
    public AdminModel getAdminModel() {
        if (adminModelImpl ==null){
            adminModelImpl =new AdminModelImpl();
        }
        return adminModelImpl;
    }
}

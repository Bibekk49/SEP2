package sem2.sep2.server.model.create;

import sem2.sep2.server.database.CreateAccount.CreateDAO;
import sem2.sep2.server.database.CreateAccount.CreateDAOImpl;

public class CreateHandlerImpl implements CreateHandler{
    private CreateDAO createDAO;
    public CreateHandlerImpl() {
        createDAO= new CreateDAOImpl();
    }


    @Override
    public String addUser(int userid, String username, String password, String userType) {
        return createDAO.addUser( userid, username, password, userType);
    }
}

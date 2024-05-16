package sem2.sep2.server.model.create;

import sem2.sep2.server.database.create.CreateDAO;
import sem2.sep2.server.database.create.CreateDAOImpl;

public class CreateHandlerImpl implements CreateHandler{
    private CreateDAO createDAO;
    public CreateHandlerImpl() {
        createDAO= new CreateDAOImpl();
    }


    @Override
    public String addUser( String username, String password) {
        return createDAO.addUser(username, password);
    }
}

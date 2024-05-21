package sem2.sep2.server.model.create;

import sem2.sep2.server.database.create.CreateDAO;
import sem2.sep2.server.database.create.CreateDAOImpl;
import sem2.sep2.shared.util.Request;

public class RegisterHandlerImpl implements RegisterHandler {
    private CreateDAO createDAO;

    public RegisterHandlerImpl() {
        createDAO = new CreateDAOImpl();
    }

    @Override
    public Request addUser(String username, String password) {
        return createDAO.addUser(username, password);
    }

    @Override
    public Request changePassword(String username, String password) {
        return createDAO.changePassword(username, password);
    }

    @Override
    public Request changeUsername(String username, String newUsername) {
        return createDAO.changeUsername(username, newUsername);
    }
}

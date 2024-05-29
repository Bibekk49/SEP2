package sem2.sep2.server.model.login;

import sem2.sep2.server.database.login.LoginDAO;
import sem2.sep2.server.database.login.LoginDAOImpl;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginHandlerImpl implements LoginHandler{
    private List<User> allUsers;
    private List<String> allUsernames;
    private LoginDAO loginDAO;
    public LoginHandlerImpl() throws SQLException {
        allUsers = new ArrayList<>();
        allUsernames = new ArrayList<>();
        loginDAO= new LoginDAOImpl();
    }
    @Override
    public Request login(String username, String password) {
        try {
            return loginDAO.login(username,password);
        } catch (SQLException e) {
            return new Request("Error connecting to database",null);
        }
    }
}

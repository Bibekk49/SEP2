package sem2.sep2.server.database.login;

import sem2.sep2.shared.util.Request;

import java.sql.SQLException;

public interface LoginDAO {
    Request login(String username, String password ) throws SQLException;
}

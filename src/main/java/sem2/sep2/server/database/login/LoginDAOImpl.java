package sem2.sep2.server.database.login;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.users.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    @Override
    public Request login(String username, String password) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=? AND password=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userId = resultSet.getString("username");
                String userType = resultSet.getString("user_type");

                if (userType.equals("Manager")) {
                    return new Request("Login successful as Manager", Manager.getInstance());
                } else if (userType.equals("Guest")) {
                    return new Request("Login successful as Guest", new Guest(userId, password));
                } else {
                    return new Request("Unknown user type", null);
                }
            } else {
                return new Request("Username or password incorrect", null);
            }
        } catch (SQLException e) {
            return new Request(e.getMessage(), null);
        }
    }


}

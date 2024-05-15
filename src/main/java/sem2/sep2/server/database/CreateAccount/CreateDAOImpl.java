package sem2.sep2.server.database.CreateAccount;

import sem2.sep2.server.database.DataBaseConnection;

import java.sql.*;

public class CreateDAOImpl implements CreateDAO {

    public CreateDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String addUser(String username, String password, String userType) { try (Connection connection = DataBaseConnection.getConnection()) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return "Username is already taken";
        } else {
            PreparedStatement statement2 = connection.prepareStatement("INSERT INTO SEP2.users(username, password, user_type) VALUES (?, ?, ?);");
            statement2.setString(1, username);
            statement2.setString(2, password);
            statement2.setString(3, userType);
            statement2.executeUpdate();
            return "User created successfully";
        }
    } catch (SQLException throwables) {
        return throwables.getMessage();
    }
    }


}

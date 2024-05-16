package sem2.sep2.server.database.create;

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
    public String addUser(String username, String password) {
        validateUsername(username);
        validatePassword(password);
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "Username is already taken";
            } else {
                String userType = username.equals("admin") ? "Manager" : "Guest";
                PreparedStatement insertUserStatement = connection.prepareStatement("INSERT INTO SEP2.users(username, password, user_type) VALUES (?, ?, ?);");
                insertUserStatement.setString(1, username);
                insertUserStatement.setString(2, password);
                insertUserStatement.setString(3, userType);
                insertUserStatement.executeUpdate();
                return "User created successfully";
            }
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
    }
    private void validatePassword(String password) {
        if (password.length() < 3) {
            throw new IllegalStateException("Password should be between 3 and 8 characters.");
        } else if (password.length() > 9) {
            throw new IllegalStateException("Password should be between 3 and 8 characters.");
        }
    }
    private void validateUsername(String username) {
        if (username.length() < 3) {
            throw new IllegalStateException("Username should be between 3 and 8 characters.");
        } else if (username.length() > 9) {
            throw new IllegalStateException("Username should be between 3 and 8 characters.");
        }
    }


}

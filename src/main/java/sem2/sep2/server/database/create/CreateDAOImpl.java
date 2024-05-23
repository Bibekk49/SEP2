package sem2.sep2.server.database.create;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.users.Manager;
import sem2.sep2.shared.util.users.User;

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
    public Request changePassword(String username, String password) {
        validatePassword(password);
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PreparedStatement updatePasswordStatement = connection.prepareStatement("UPDATE SEP2.users SET password=? WHERE username=?;");
                updatePasswordStatement.setString(1, password);
                updatePasswordStatement.setString(2, username);
                updatePasswordStatement.executeUpdate();
                return new Request("Password changed successfully", null);
            } else {
                return new Request("Username does not exist", null);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Failed to change password: " + throwables.getMessage());
        }
    }

    @Override
    public Request changeUsername(String username, String newUsername) {
        validateUsername(newUsername);
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PreparedStatement updateUsernameStatement = connection.prepareStatement("UPDATE SEP2.users SET username=? WHERE username=?;");
                updateUsernameStatement.setString(1, newUsername);
                updateUsernameStatement.setString(2, username);
                updateUsernameStatement.executeUpdate();
                return new Request("Username changed successfully", null);
            } else {
                return new Request("Username does not exist", null);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Failed to change username: " + throwables.getMessage());
        }
    }

    @Override
    public Request GetUser(String username) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String userType = resultSet.getString("user_type");
                User user = userType.equals("Manager") ? Manager.getInstance() : new Guest(username, resultSet.getString("password"));
                return new Request("User found", user);
            } else {
                return new Request("User not found", null);
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Failed to get user: " + throwables.getMessage());
        }
    }


    @Override
    public Request addUser(String username, String password) {
        validateUsername(username);
        validatePassword(password);
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Request("Username already exists", null);
            } else {
                String userType = username.equals("admin") ? "Manager" : "Guest";
                PreparedStatement insertUserStatement = connection.prepareStatement("INSERT INTO SEP2.users(username, password, user_type) VALUES (?, ?, ?);");
                insertUserStatement.setString(1, username);
                insertUserStatement.setString(2, password);
                insertUserStatement.setString(3, userType);
                insertUserStatement.executeUpdate();
                return new Request("User created successfully", null);
            }
        } catch (SQLException throwables) {
            return new Request("Failed to create user: " + throwables.getMessage(), null);
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

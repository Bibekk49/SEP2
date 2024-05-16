package sem2.sep2.server.database.user;

import sem2.sep2.server.database.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    public String changePassword(String username, String password) {
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
                return "Password changed successfully";
            } else {
                return "Username does not exist";
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Failed to change password: " + throwables.getMessage());
        }
    }

    @Override
    public String changeUsername(String username, String newUsername) {
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
                return "Username changed successfully";
            } else {
                return "Username does not exist";
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Failed to change username: " + throwables.getMessage());
        }
    }

    private void validatePassword(String password) {
        if (password.length() < 3 || password.length() > 15) {
            throw new IllegalArgumentException("Password should be between 3 and 15 characters.");
        }
    }

    private void validateUsername(String username) {
        if (username.length() < 3 || username.length() > 15) {
            throw new IllegalArgumentException("Username should be between 3 and 15 characters.");
        }
    }
}
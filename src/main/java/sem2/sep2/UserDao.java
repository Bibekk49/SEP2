package sem2.sep2;

import java.sql.*;

public class UserDao {
  private Connection connection;

  public UserDao(Connection connection) {
    this.connection = connection;
  }

  public void createUser(String username, String password) throws SQLException {
    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      preparedStatement.executeUpdate();
    }
  }//jdbc:postgresql://localhost:5432/postgres

  public void deleteUser(int userId) throws SQLException {
    String sql = "DELETE FROM users WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, userId);
      preparedStatement.executeUpdate();
    }
  }

  public void updateUsername(int userId, String newUsername) throws SQLException {
    String sql = "UPDATE users SET username = ? WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, newUsername);
      preparedStatement.setInt(2, userId);
      preparedStatement.executeUpdate();
    }
  }

  public void updatePassword(int userId, String newPassword) throws SQLException {
    String sql = "UPDATE users SET password = ? WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, newPassword);
      preparedStatement.setInt(2, userId);
      preparedStatement.executeUpdate();
    }
  }
}

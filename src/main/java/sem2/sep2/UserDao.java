package sem2.sep2;

import sem2.sep2.shared.util.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
  public static Connection connection;

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

  public Guest readById(int userId) throws SQLException {
    Guest guest = null;
    String sql = "SELECT * FROM users WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, userId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          int id = resultSet.getInt("user_id");
          String username = resultSet.getString("username");
          String password = resultSet.getString("password");
          guest = new Guest(id, username, password);
        }
      }
    }
    return guest;
  }

  public static ArrayList<Guest> getAllUsers() throws SQLException {
    ArrayList<Guest> userList = new ArrayList<>();
    String sql = "SELECT * FROM users ORDER BY user_id";
    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
      while (resultSet.next()) {
        int id = resultSet.getInt("user_id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        Guest guest = new Guest(id, username, password);
        userList.add(guest);
      }
    }
    return userList;
  }


}

package sem2.sep2.server.Dao;

import sem2.sep2.shared.Dao.UserDao;
import sem2.sep2.shared.util.Guest;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao
{
  public static Connection connection;

  public UserDaoImpl(Connection connection) {
    super();
    this.connection = connection;
  }
  @Override
  public void createUser(String username, String password) throws SQLException,
      RemoteException
  {
    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      preparedStatement.executeUpdate();
    }
  }//jdbc:postgresql://localhost:5432/postgres
  @Override
  public void deleteUser(int userId) throws SQLException,RemoteException {
    String sql = "DELETE FROM users WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, userId);
      preparedStatement.executeUpdate();
    }
  }
  @Override
  public void updateUsername(int userId, String newUsername) throws SQLException,RemoteException {
    String sql = "UPDATE users SET username = ? WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, newUsername);
      preparedStatement.setInt(2, userId);
      preparedStatement.executeUpdate();
    }
  }
  @Override
  public void updatePassword(int userId, String newPassword) throws SQLException,RemoteException {
    String sql = "UPDATE users SET password = ? WHERE user_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, newPassword);
      preparedStatement.setInt(2, userId);
      preparedStatement.executeUpdate();
    }
  }
  @Override
  public Guest readById(int userId) throws SQLException,RemoteException {
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
  @Override
  public ArrayList<Guest> getAllUsers() throws SQLException,RemoteException {
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
  @Override
  public boolean login(String username,String password)throws RemoteException,SQLException{
    String sql ="SELECT * FROM users WHERE username = ? AND password = ?";
    try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
      preparedStatement.setString(1,username);
      preparedStatement.setString(2,password);
      ResultSet resultSet = preparedStatement.executeQuery();
      return resultSet.next();
    }
  }


}

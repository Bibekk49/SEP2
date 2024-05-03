package sem2.sep2;

import sem2.sep2.shared.util.room.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomDao
{
  public static Connection connection;
  public RoomDao(Connection connection) {
    this.connection = connection;
  }
  //add
  public void createRoom(Room room) throws SQLException
  {
    String sql = "INSERT INTO rooms (room_id, type, price, availability) VALUES (?, ?, ?,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1,room.getRoom_id());
      preparedStatement.setString(2, room.getType());
      preparedStatement.setDouble(3, room.getPrice());
      preparedStatement.setString(4,room.getAvailability());
      preparedStatement.executeUpdate();
    }
  }
  public boolean isRoomExist(int roomId) throws SQLException {
    String sql = "SELECT COUNT(*) FROM rooms WHERE room_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, roomId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          int count = resultSet.getInt(1);
          return count > 0;
        }
      }
    }
    return false;
  }
  public Room readById(int roomId) throws SQLException {
    String sql = "SELECT * FROM rooms WHERE room_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, roomId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          int room_id = resultSet.getInt("room_id");
          String type = resultSet.getString("type");
          Double price = resultSet.getDouble("price");
          String availability = resultSet.getString("availability");
          return new Room(room_id,type,price,availability);
        }
      }
    }
    return null;//can't find the room by id
  }
  public boolean deleteRoom(int room_id) {
    String sql = "DELETE FROM rooms WHERE room_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, room_id);
      int rowsAffected = preparedStatement.executeUpdate();
      if (rowsAffected > 0) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }


  public  ArrayList<Room> getAllRooms() throws SQLException {
    ArrayList<Room> roomList = new ArrayList<>();
    String sql = "SELECT * FROM rooms ORDER BY room_id";
    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
      while (resultSet.next()) {
        int room_id = resultSet.getInt("room_id");
        String type = resultSet.getString("type");
        Double price = resultSet.getDouble("price");
        String available = resultSet.getString("availability");
        Room room = new Room(room_id,type,price,available);
        roomList.add(room);
      }
    }
    return roomList;
  }
}

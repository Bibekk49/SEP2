package sem2.sep2;

import sem2.sep2.shared.util.Guest;
import sem2.sep2.shared.util.room.Room;

import java.sql.*;
import java.util.ArrayList;

public class RoomDao
{
  public static Connection connection;
  public RoomDao(Connection connection) {
    this.connection = connection;
  }

  public void createRoom(Room room) throws SQLException
  {
    String sql = "INSERT INTO rooms (room_id, type, price) VALUES (?, ?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1,room.getRoom_id());
      preparedStatement.setString(2, room.getType());
      preparedStatement.setDouble(3, room.getPrice());
      preparedStatement.executeUpdate();
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
        Room room = new Room(room_id,type,price);
        roomList.add(room);
      }
    }
    return roomList;
  }

}

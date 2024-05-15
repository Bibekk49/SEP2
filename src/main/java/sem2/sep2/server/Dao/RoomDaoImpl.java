package sem2.sep2.server.Dao;

import sem2.sep2.shared.Dao.RoomDao;
import sem2.sep2.shared.util.Room;

import java.rmi.RemoteException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao
{
  public static Connection connection;
  public RoomDaoImpl(Connection connection) throws RemoteException
  {
    super();
    this.connection = connection;
  }
  //add
  @Override
  public void createRoom(Room room) throws SQLException,RemoteException
  {
    String sql = "INSERT INTO rooms (room_id, type, price, status) VALUES (?, ?, ?,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1,room.getRoom_id());
      preparedStatement.setString(2, room.getType());
      preparedStatement.setDouble(3, room.getPrice());
      preparedStatement.setString(4,room.getStatus());
      preparedStatement.executeUpdate();
    }
  }
  @Override
  public boolean isRoomExist(int roomId) throws SQLException,RemoteException {
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
  @Override
  public Room readById(int roomId) throws SQLException,RemoteException {
    String sql = "SELECT * FROM rooms WHERE room_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, roomId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          int room_id = resultSet.getInt("room_id");
          String type = resultSet.getString("type");
          Double price = resultSet.getDouble("price");
          String status = resultSet.getString("status");
          return new Room(room_id,type,price,status);
        }
      }
    }
    return null;
  }
  @Override
  public boolean deleteRoom(int room_id)throws RemoteException{
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

  @Override
  public ArrayList<Room> getAllRooms() throws SQLException,RemoteException {
    ArrayList<Room> roomList = new ArrayList<>();
    String sql = "SELECT * FROM rooms ORDER BY room_id";
    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
      while (resultSet.next()) {
        int room_id = resultSet.getInt("room_id");
        String type = resultSet.getString("type");
        Double price = resultSet.getDouble("price");
        String status = resultSet.getString("status");
        Room room = new Room(room_id,type,price,status);
        roomList.add(room);
      }
    }
    return roomList;
  }
  public List<Room> searchRooms(LocalDate checkInDate, LocalDate checkOutDate) throws Exception {
    String sql = "SELECT r.room_id, r.type, r.price " +
        "FROM Rooms r " +
        "LEFT JOIN Bookings b ON r.room_id = b.room_id AND (" +
        "    (b.check_in_date BETWEEN ? AND ?) OR " +
        "    (b.check_out_date BETWEEN ? AND ?) OR " +
        "    (? BETWEEN b.check_in_date AND b.check_out_date) OR " +
        "    (? BETWEEN b.check_in_date AND b.check_out_date)" +
        ") " +
        "WHERE b.booking_id IS NULL AND r.status = 'Available'";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

      preparedStatement.setDate(1, java.sql.Date.valueOf(checkInDate));
      preparedStatement.setDate(2, java.sql.Date.valueOf(checkOutDate));
      preparedStatement.setDate(3, java.sql.Date.valueOf(checkInDate));
      preparedStatement.setDate(4, java.sql.Date.valueOf(checkOutDate));
      preparedStatement.setDate(5, java.sql.Date.valueOf(checkInDate));
      preparedStatement.setDate(6, java.sql.Date.valueOf(checkOutDate));

      ResultSet rs = preparedStatement.executeQuery();
      List<Room> rooms = new ArrayList<>();
      while (rs.next()) {
        Room room = new Room(rs.getInt("room_id"),rs.getString("type"),
            rs.getDouble("price"),"Available");
        rooms.add(room);
      }
      return rooms;
    } catch (SQLException e) {
      throw new Exception("Database error: " + e.getMessage(), e);
    }
  }
}

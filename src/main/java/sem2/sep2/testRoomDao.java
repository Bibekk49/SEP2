package sem2.sep2;

import sem2.sep2.shared.util.room.Room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testRoomDao
{
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/postgres";//?currentSchema=jdbc
    String username = "postgres";
    String password = "050420";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      RoomDao roomDao = new RoomDao(connection);
      roomDao.createRoom(new Room(201,"single room",1000.0));
      roomDao.createRoom(new Room(202,"single room",1100.0));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

package sem2.sep2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomDao
{
  public static Connection connection;
  public RoomDao(Connection connection) {
    this.connection = connection;
  }

  public void createRoom(String username, String password) throws SQLException
  {
    String sql = "INSERT INTO rooms (username, password) VALUES (?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      preparedStatement.executeUpdate();
    }
  }

}

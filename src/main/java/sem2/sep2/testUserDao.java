package sem2.sep2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testUserDao
{
  public static void main(String[] args) {
    //连接数据库并使用 UserDao 类 
    String url = "jdbc:postgresql://localhost:5432/postgres";//?currentSchema=jdbc
    String username = "postgres";
    String password = "050420";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      UserDao userDao = new UserDao(connection);

      userDao.createUser("user1", "password1");
      userDao.createUser("user2", "password2");

      userDao.deleteUser(1);

      userDao.updateUsername(2, "new_username");

      userDao.updatePassword(2, "new_password");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

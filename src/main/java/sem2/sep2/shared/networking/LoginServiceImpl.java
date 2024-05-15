package sem2.sep2.shared.networking;

import sem2.sep2.server.Dao.RoomDaoImpl;
import sem2.sep2.server.Dao.UserDaoImpl;
import sem2.sep2.shared.Dao.RoomDao;
import sem2.sep2.shared.Dao.UserDao;
import sem2.sep2.shared.util.Room;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class LoginServiceImpl extends UnicastRemoteObject implements LoginService
{
  private UserDao userDao;
  private RoomDao roomDao;
  public LoginServiceImpl() throws RemoteException, SQLException
  {
    super();
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "050420";
    Connection connection = DriverManager.getConnection(url, username, password);
    userDao = new UserDaoImpl(connection);
    roomDao = new RoomDaoImpl(connection);
  }
  @Override
  public boolean login(String username,String password)
      throws RemoteException, SQLException
  {
    if(userDao.login(username,password)){
      return true;
    }else{
      return false;
    }
  }
  @Override
  public List<Room> findAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) throws Exception {
    return roomDao.searchRooms(checkInDate,checkOutDate);
  }
}

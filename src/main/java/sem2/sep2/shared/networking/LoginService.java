package sem2.sep2.shared.networking;

import sem2.sep2.shared.util.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface LoginService extends Remote
{
  boolean login(String username,String password)
      throws RemoteException, SQLException;
  List<Room> findAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) throws Exception;
}

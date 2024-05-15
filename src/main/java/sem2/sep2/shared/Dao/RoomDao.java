package sem2.sep2.shared.Dao;

import sem2.sep2.shared.util.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface RoomDao extends Remote
{
  void createRoom(Room room) throws SQLException, RemoteException;
  boolean isRoomExist(int roomId) throws SQLException, RemoteException;
  Room readById(int roomId) throws SQLException, RemoteException;
  boolean deleteRoom(int room_id) throws SQLException, RemoteException;
  ArrayList<Room> getAllRooms() throws SQLException, RemoteException;

  List<Room> searchRooms(LocalDate checkInDate, LocalDate checkOutDate) throws Exception;
}

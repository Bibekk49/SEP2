package sem2.sep2.shared.Dao;

import sem2.sep2.shared.util.Guest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao extends Remote
{
  void createUser(String username, String password) throws SQLException,
      RemoteException;
  void deleteUser(int userId) throws SQLException, RemoteException;
  void updateUsername(int userId, String newUsername) throws SQLException,
      RemoteException;
  void updatePassword(int userId, String newPassword) throws SQLException,
      RemoteException;
  Guest readById(int userId) throws SQLException, RemoteException;
  ArrayList<Guest> getAllUsers() throws SQLException, RemoteException;
  boolean login(String username,String password)throws RemoteException,
      SQLException;
}

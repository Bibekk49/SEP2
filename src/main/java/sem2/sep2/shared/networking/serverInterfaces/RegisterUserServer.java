package sem2.sep2.shared.networking.serverInterfaces;

import sem2.sep2.shared.util.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegisterUserServer extends Remote {
    Request addUser(String username, String password) throws RemoteException;
    Request changePassword(String username, String password) throws RemoteException;
    Request changeUsername(String username, String newUsername) throws RemoteException;
}

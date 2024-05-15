package sem2.sep2.shared.networking.serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegisterUserServer extends Remote {
    String addUser(String username, String password, String userType) throws RemoteException;
}

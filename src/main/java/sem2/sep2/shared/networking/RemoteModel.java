package sem2.sep2.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteModel extends Remote {
    void register(int id,String userName, String password) throws RemoteException;
    void login(int id,String userName, String password) throws RemoteException;
}

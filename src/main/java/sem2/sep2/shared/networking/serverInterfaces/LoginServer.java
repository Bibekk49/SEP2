package sem2.sep2.shared.networking.serverInterfaces;

import sem2.sep2.shared.util.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote {
    Request isLoginPossible(String username, String password) throws RemoteException;

}

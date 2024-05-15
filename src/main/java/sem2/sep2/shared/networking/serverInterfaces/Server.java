package sem2.sep2.shared.networking.serverInterfaces;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    RegisterUserServer getRegisterUserServer() throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;
//    void search/reserve
}

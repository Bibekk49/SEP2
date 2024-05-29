package sem2.sep2.shared.networking.serverInterfaces;

import sem2.sep2.client.networking.contact.ContactClient;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    RegisterUserServer getRegisterUserServer() throws RemoteException;
    ContactManagerServer getContactManagerServer() throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;

    RoomServer getRoomServer() throws RemoteException;
//    void search/reserve
}

package sem2.sep2.server.networking;

import sem2.sep2.shared.networking.serverInterfaces.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {
    private LoginServer loginServer;
    private RegisterUserServer registerUserServer;
    private ContactManagerServer contactManagerServer;
    private RoomServer roomServer;
    public ServerImpl(LoginServer loginServer, RegisterUserServer registerUserServer,ContactManagerServer contactManagerServer,RoomServer roomServer) throws RemoteException {
        this.loginServer = loginServer;
        this.registerUserServer = registerUserServer;
        this.contactManagerServer = contactManagerServer;
        this.roomServer = roomServer;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public LoginServer getLoginServer() throws RemoteException {
        return loginServer;
    }

    @Override
    public RegisterUserServer getRegisterUserServer() throws RemoteException {
        return registerUserServer;
    }
    @Override
    public ContactManagerServer getContactManagerServer() throws RemoteException{
        return contactManagerServer;
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server started.....");
    }

    @Override
    public RoomServer getRoomServer() throws RemoteException{
        return roomServer;
    }
}

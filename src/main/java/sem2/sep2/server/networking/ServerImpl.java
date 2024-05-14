package sem2.sep2.server.networking;

import sem2.sep2.shared.networking.serverInterfaces.LoginServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {
    private LoginServer loginServer;
    public ServerImpl(LoginServer loginServer) throws RemoteException {
        this.loginServer = loginServer;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public LoginServer getLoginServer() throws RemoteException {
        return loginServer;
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server started.....");
    }
}

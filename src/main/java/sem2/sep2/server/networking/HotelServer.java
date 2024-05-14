package sem2.sep2.server.networking;

import sem2.sep2.client.core.ModelFactory;
import sem2.sep2.shared.networking.RemoteModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class HotelServer implements RemoteModel {
    private final ModelFactory modelFactory;
    private int port;

    public HotelServer(ModelFactory modelFactory, int port) throws RemoteException, MalformedURLException {
        this.modelFactory = modelFactory;
        this.port = port;

        LocateRegistry.createRegistry(port);
        UnicastRemoteObject.exportObject(this, 0);
        Naming.rebind("HotelServer", this);
    }

    @Override
    public void register(int id, String userName, String password) throws RemoteException {
        modelFactory.getLoginModel().register(id, userName, password);
    }

    @Override
    public void login(int id, String userName, String password) throws RemoteException {
        modelFactory.getLoginModel().login(id, userName, password);
    }
}

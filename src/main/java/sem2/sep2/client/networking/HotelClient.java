package sem2.sep2.client.networking;

import sem2.sep2.shared.networking.RemoteModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HotelClient implements RemoteModel {
    private final RemoteModel remoteModel;

    public HotelClient(String host, int port) throws MalformedURLException, NotBoundException, RemoteException {
        this.remoteModel = (RemoteModel) Naming.lookup("rmi://" + host + ":" + port + "/HotelServer");
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void register(int id, String userName, String password) throws RemoteException {
        remoteModel.register(id, userName, password);
    }

    @Override
    public void login(int id, String userName, String password) throws RemoteException {
        remoteModel.login(id, userName, password);
    }
}
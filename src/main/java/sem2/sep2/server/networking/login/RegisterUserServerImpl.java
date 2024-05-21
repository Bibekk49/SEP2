package sem2.sep2.server.networking.login;

import sem2.sep2.server.model.create.RegisterHandler;
import sem2.sep2.shared.networking.serverInterfaces.RegisterUserServer;
import sem2.sep2.shared.util.Request;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RegisterUserServerImpl implements RegisterUserServer{
    private RegisterHandler createHandler;
    public RegisterUserServerImpl(RegisterHandler createHandler) throws RemoteException {
        this.createHandler = createHandler;
        UnicastRemoteObject.exportObject(this,0);
    }
    @Override
    public Request addUser(String username, String password) {
       return createHandler.addUser(username,password);
    }

    @Override
    public Request changePassword(String username, String password) throws RemoteException {
        return createHandler.changePassword(username,password);
    }

    @Override
    public Request changeUsername(String username, String newUsername) throws RemoteException {
        return createHandler.changeUsername(username,newUsername);
    }

}

package sem2.sep2.server.networking.login;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.server.model.create.CreateHandler;
import sem2.sep2.shared.networking.serverInterfaces.RegisterUserServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUserServerImpl implements RegisterUserServer{
    private CreateHandler createHandler;
    public RegisterUserServerImpl(CreateHandler createHandler) throws RemoteException {
        this.createHandler = createHandler;
        UnicastRemoteObject.exportObject(this,0);
    }
    @Override
    public String addUser(String username, String password, String userType) {
       return createHandler.addUser(username,password,userType);
    }

}

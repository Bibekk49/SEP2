package sem2.sep2.server;

import sem2.sep2.server.model.create.CreateHandler;
import sem2.sep2.server.model.create.CreateHandlerImpl;
import sem2.sep2.server.model.login.LoginHandler;
import sem2.sep2.server.model.login.LoginHandlerImpl;
import sem2.sep2.server.networking.ServerImpl;
import sem2.sep2.server.networking.contact.ContactManagerServerImpl;
import sem2.sep2.server.networking.login.LoginServerImpl;
import sem2.sep2.server.networking.login.RegisterUserServerImpl;
import sem2.sep2.shared.networking.serverInterfaces.ContactManagerServer;
import sem2.sep2.shared.networking.serverInterfaces.LoginServer;
import sem2.sep2.shared.networking.serverInterfaces.RegisterUserServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginHandler loginHandler = new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);
        ContactManagerServer contactManagerServer = new ContactManagerServerImpl();

        CreateHandler createHandler = new CreateHandlerImpl();
        RegisterUserServer registerUserServer = new RegisterUserServerImpl(createHandler);

        Server server = new ServerImpl(loginServer, registerUserServer,contactManagerServer);
        server.startServer();
    }
}

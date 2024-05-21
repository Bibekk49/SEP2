package sem2.sep2.server;

import sem2.sep2.server.model.contactManager.ContactManagerHandler;
import sem2.sep2.server.model.contactManager.ContactManagerHandlerImpl;
import sem2.sep2.server.model.create.CreateHandler;
import sem2.sep2.server.model.create.CreateHandlerImpl;
import sem2.sep2.server.model.login.LoginHandler;
import sem2.sep2.server.model.login.LoginHandlerImpl;
import sem2.sep2.server.model.room.RoomHandler;
import sem2.sep2.server.model.room.RoomHandlerImpl;
import sem2.sep2.server.networking.ServerImpl;
import sem2.sep2.server.networking.contact.ContactManagerServerImpl;
import sem2.sep2.server.networking.login.LoginServerImpl;
import sem2.sep2.server.networking.login.RegisterUserServerImpl;
import sem2.sep2.server.networking.room.RoomServerImpl;
import sem2.sep2.shared.networking.serverInterfaces.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginHandler loginHandler = new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);

        RoomHandler roomHandler = new RoomHandlerImpl();
        RoomServer roomServer = new RoomServerImpl(roomHandler);

        ContactManagerHandler contactManagerHandler = new ContactManagerHandlerImpl();
        ContactManagerServer contactManagerServer = new ContactManagerServerImpl(contactManagerHandler);

        CreateHandler createHandler = new CreateHandlerImpl();
        RegisterUserServer registerUserServer = new RegisterUserServerImpl(createHandler);

        Server server = new ServerImpl(loginServer, registerUserServer,contactManagerServer,roomServer);

        server.startServer();
    }
}

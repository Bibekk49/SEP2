package sem2.sep2.server;

import sem2.sep2.server.model.login.LoginHandler;
import sem2.sep2.server.model.login.LoginHandlerImpl;
import sem2.sep2.server.networking.ServerImpl;
import sem2.sep2.server.networking.login.LoginServerImpl;
import sem2.sep2.shared.networking.serverInterfaces.LoginServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginHandler loginHandler = new LoginHandlerImpl();
        LoginServer loginServer = new LoginServerImpl(loginHandler);

        Server server = new ServerImpl(loginServer);
        server.startServer();
    }
}

package sem2.sep2.server.networking.login;

import sem2.sep2.server.model.login.LoginHandler;
import sem2.sep2.shared.networking.serverInterfaces.LoginServer;
import sem2.sep2.shared.util.Request;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerImpl implements LoginServer {
    private LoginHandler loginHandler;
    public LoginServerImpl(LoginHandler loginHandler) throws RemoteException {
        this.loginHandler = loginHandler;
        UnicastRemoteObject.exportObject(this, 0);

    }
    @Override
    public Request isLoginPossible(String username, String password) throws RemoteException {
        return loginHandler.login( username, password);
    }
}

package sem2.sep2.client.networking.register;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;
import sem2.sep2.shared.util.Request;

public class RegisterClientImpl implements RegisterClient {
    private Server server;
    public RegisterClientImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public Request addUser(String username, String password) {
        try {
            return server.getRegisterUserServer().addUser(username,password);
        } catch (Exception e) {
            return new Request("Cannot connect to server",null);
        }
    }

    @Override
    public Request changePassword(String username, String password) {
        try {
            return server.getRegisterUserServer().changePassword(username,password);
        } catch (Exception e) {
            return new Request("Cannot connect to server",null);
        }
    }

    @Override
    public Request changeUsername(String username, String newUsername) {
        try {
            return server.getRegisterUserServer().changeUsername(username,newUsername);
        } catch (Exception e) {
            return new Request("Cannot connect to server",null);
        }
    }
}

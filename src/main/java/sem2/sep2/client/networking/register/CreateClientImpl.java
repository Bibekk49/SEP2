package sem2.sep2.client.networking.register;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;

public class CreateClientImpl implements CreateClient{
    private Server server;
    public CreateClientImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public String addUser(String username, String password) {
        try {
            return server.getRegisterUserServer().addUser(username,password);
        } catch (Exception e) {
            return "Cannot connect to server";
        }
    }
}

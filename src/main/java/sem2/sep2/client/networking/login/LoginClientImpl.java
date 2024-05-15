package sem2.sep2.client.networking.login;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;
import sem2.sep2.shared.util.Request;

public class LoginClientImpl implements LoginClient{
    private Server server;
    public LoginClientImpl(){
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public Request login(String username, String password) {
        try {
            return server.getLoginServer().isLoginPossible(username,password);
        } catch (Exception e){
            e.printStackTrace();
            return new Request("Cannot connect to server",null);
        }
    }
}

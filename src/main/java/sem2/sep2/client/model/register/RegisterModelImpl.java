package sem2.sep2.client.model.register;

import sem2.sep2.client.networking.register.RegisterClient;
import sem2.sep2.shared.util.Request;

public class RegisterModelImpl implements RegisterModel {
    private RegisterClient client;
    public RegisterModelImpl(RegisterClient client) {
        this.client = client;
    }
    @Override
    public Request addUser(String username, String password) {
        return client.addUser(username, password);
    }

    @Override
    public Request changePassword(String username, String password) {
        return client.changePassword(username, password);
    }

    @Override
    public Request changeUsername(String username, String newUsername) {
        return client.changeUsername(username, newUsername);
    }
    @Override
    public Request GetUser(String username) {
        return client.GetUser(username);
    }
}

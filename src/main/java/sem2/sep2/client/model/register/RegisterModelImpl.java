package sem2.sep2.client.model.register;

import sem2.sep2.client.networking.register.RegisterClient;

public class RegisterModelImpl implements RegisterModel {
    private RegisterClient client;
    public RegisterModelImpl(RegisterClient client) {
        this.client = client;
    }
    @Override
    public String addUser(String username, String password) {
        return client.addUser(username, password);
    }

    @Override
    public String changePassword(String username, String password) {
        return client.changePassword(username, password);
    }

    @Override
    public String changeUsername(String username, String newUsername) {
        return client.changeUsername(username, newUsername);
    }
}

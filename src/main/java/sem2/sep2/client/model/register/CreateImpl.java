package sem2.sep2.client.model.register;

import sem2.sep2.client.networking.register.CreateClient;

public class CreateImpl implements CreateModel{
    private CreateClient client;
    public CreateImpl(CreateClient client) {
        this.client = client;
    }
    @Override
    public String addUser(String username, String password) {
        return client.addUser(username, password);
    }
}

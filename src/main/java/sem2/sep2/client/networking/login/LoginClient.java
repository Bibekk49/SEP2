package sem2.sep2.client.networking.login;

import sem2.sep2.shared.util.Request;

public interface LoginClient {
    Request login(String username, String password);
}

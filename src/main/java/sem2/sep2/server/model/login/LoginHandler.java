package sem2.sep2.server.model.login;

import sem2.sep2.shared.util.Request;

public interface LoginHandler {
    Request login(String username, String password);
}

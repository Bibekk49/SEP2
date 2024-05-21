package sem2.sep2.server.model.create;

import sem2.sep2.shared.util.Request;

public interface RegisterHandler {
    Request addUser(String username, String password);

    Request changePassword(String username, String password);

    Request changeUsername(String username, String newUsername);
}

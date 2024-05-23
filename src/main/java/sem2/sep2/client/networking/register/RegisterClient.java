package sem2.sep2.client.networking.register;

import sem2.sep2.shared.util.Request;

public interface RegisterClient {
  Request addUser(String username, String password);
  Request changePassword(String username, String password);
  Request changeUsername(String username, String newUsername);
  Request GetUser(String username);

}

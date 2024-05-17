package sem2.sep2.client.networking.register;

public interface CreateClient {
  String addUser(String username, String password);
  String changePassword(String username, String password);
  String changeUsername(String username, String newUsername);

}

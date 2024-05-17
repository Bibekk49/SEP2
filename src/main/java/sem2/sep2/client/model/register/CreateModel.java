package sem2.sep2.client.model.register;

public interface CreateModel {
    String addUser(String username, String password);
    String changePassword(String username, String password);
    String changeUsername(String username, String newUsername);
}

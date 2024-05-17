package sem2.sep2.server.model.create;

public interface CreateHandler {
    String addUser( String username, String password);
    String changePassword(String username, String password);
    String changeUsername(String username, String newUsername);
}

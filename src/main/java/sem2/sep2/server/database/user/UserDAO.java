package sem2.sep2.server.database.user;

public interface UserDAO {
    String changePassword(String username, String password);
    String changeUsername(String username, String newUsername);
}

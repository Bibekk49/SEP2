package sem2.sep2.server.database.create;



public interface CreateDAO {

    String addUser(String username, String password);
    String changePassword(String username, String password);
    String changeUsername(String username, String newUsername);
}

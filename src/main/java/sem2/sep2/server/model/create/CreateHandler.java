package sem2.sep2.server.model.create;

public interface CreateHandler {
    String addUser(int userid, String username, String password, String userType);
}

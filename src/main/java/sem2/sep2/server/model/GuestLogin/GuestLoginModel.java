package sem2.sep2.server.model.GuestLogin;

import sem2.sep2.shared.util.users.Guest;

public interface GuestLoginModel{
    void login(int id,String username, String password);
    void register(int id,String username, String password);
    void setPassword(Guest guest,String password);
    String getPassword(Guest guest);
    void changeUsername(Guest guest,String username);
}

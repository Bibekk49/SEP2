package sem2.sep2.client.model.login;

import sem2.sep2.shared.util.Request;

public interface LoginModel
{
    Request login(String username, String password);

    void setUsername(String userName);

    String getUsername();
    void setUserType(String userType);

    String getUserType();
}

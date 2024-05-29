package sem2.sep2.client.model.login;

import sem2.sep2.client.networking.login.LoginClient;
import sem2.sep2.shared.util.Request;

public class LoginModelImpl implements LoginModel {
    private LoginClient client;
    private String userName;
    private String userType;

    public LoginModelImpl(LoginClient loginClient) {
        this.client = loginClient;
    }

    @Override
    public Request login(String username, String password) {
        return client.login(username, password);

    }

    @Override
    public void setUsername(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String getUserType() {
        return userType;
    }
}

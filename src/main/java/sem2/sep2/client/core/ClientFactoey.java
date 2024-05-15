package sem2.sep2.client.core;

import sem2.sep2.client.networking.login.LoginClient;
import sem2.sep2.client.networking.login.LoginClientImpl;

public class ClientFactoey {
    private LoginClient loginClient;
    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }
}

package sem2.sep2.client.core;

import sem2.sep2.client.networking.login.LoginClient;
import sem2.sep2.client.networking.login.LoginClientImpl;
import sem2.sep2.client.networking.register.CreateClient;
import sem2.sep2.client.networking.register.CreateClientImpl;

public class ClientFactoey {
    private LoginClient loginClient;
    private CreateClient createCLient;
    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public CreateClient getCreateClient() {
        if (createCLient == null) {
            createCLient = new CreateClientImpl();
        }
        return createCLient;
    }
}

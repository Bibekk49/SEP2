package sem2.sep2.client.core;

import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.login.LoginModelImpl;

public class ModelFactory {
    private ClientFactoey clientFactory;
    private LoginModel loginModel;
    public ModelFactory(ClientFactoey clientFactory) {
        this.clientFactory = clientFactory;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModel;
    }
}

package sem2.sep2.client.core;

import sem2.sep2.client.model.clientloginModel.ClientLoginModel;
import sem2.sep2.client.model.clientloginModel.ClientLoginModelImpl;

public class ModelFactory {
    private ClientLoginModelImpl loginModelImpl;

    public ClientLoginModel getLoginModel() {
        if (loginModelImpl == null) {
            loginModelImpl = new ClientLoginModelImpl();
        }
        return loginModelImpl;
    }


    public ClientLoginModel getLoginViewModel() {
        return null;
    }
}

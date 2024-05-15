package sem2.sep2.client.core;

import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.login.LoginModelImpl;
import sem2.sep2.client.model.register.CreateImpl;
import sem2.sep2.client.model.register.CreateModel;
import sem2.sep2.client.model.reserve.ReserveModel;
import sem2.sep2.client.model.reserve.ReserveModelImpl;

public class ModelFactory {
    private ClientFactoey clientFactory;
    private LoginModel loginModel;
    private CreateModel createModel;
    private ReserveModel reserveModel;
    public ModelFactory(ClientFactoey clientFactory) {
        this.clientFactory = clientFactory;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModel;
    }

    public CreateModel getCreateModel() {
        if (createModel == null) {
            createModel = new CreateImpl(clientFactory.getCreateClient());
        }
        return createModel;
    }

    public ReserveModel getReserveModel() {
        if (reserveModel == null) {
            reserveModel = new ReserveModelImpl(clientFactory.getReserveClient());
        }
        return reserveModel;
    }
}

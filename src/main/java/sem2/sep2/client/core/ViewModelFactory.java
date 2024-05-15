package sem2.sep2.client.core;

import sem2.sep2.client.view.loginView.LoginViewModel;
import sem2.sep2.client.view.loginView.ViewState;
import sem2.sep2.client.view.reserveView.ReserveViewModel;

public class ViewModelFactory {
    private  ModelFactory modelFactory;
    private LoginViewModel clientLoginViewModel;
    private ReserveViewModel clientReserveViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if (clientLoginViewModel == null) {
            clientLoginViewModel = new LoginViewModel(modelFactory.getLoginModel(), modelFactory.getCreateModel());
        }
        return clientLoginViewModel;
    }

    public ReserveViewModel getReserveViewModel() {
        if (clientReserveViewModel == null) {
            clientReserveViewModel = new ReserveViewModel(modelFactory.getReserveModel());
        }
        return clientReserveViewModel;
    }
}

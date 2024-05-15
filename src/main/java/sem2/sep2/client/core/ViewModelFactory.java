package sem2.sep2.client.core;

import sem2.sep2.client.view.loginView.LoginViewModel;
import sem2.sep2.client.view.loginView.ViewState;

public class ViewModelFactory {
    private  ModelFactory modelFactory;
    private LoginViewModel clientLoginViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if (clientLoginViewModel == null) {
            clientLoginViewModel = new LoginViewModel(modelFactory.getLoginModel(), new ViewState());
        }
        return clientLoginViewModel;
    }
}

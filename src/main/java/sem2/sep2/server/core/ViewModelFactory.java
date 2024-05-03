package sem2.sep2.server.core;

import sem2.sep2.server.core.ModelFactory;
import sem2.sep2.server.viewModel.LoginViewModel;

public class ViewModelFactory {
    private final ModelFactory modelFactory;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory.getAdminModel());
        }
        return loginViewModel;
    }
}

package sem2.sep2.server.core;

import sem2.sep2.server.view.loginView.LoginViewModel;
import sem2.sep2.server.view.manageRoomView.ManageRoomViewModel;

public class ViewModelFactory {
    private final ModelFactory modelFactory;
    private ManageRoomViewModel viewModel;
    private LoginViewModel loginViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ManageRoomViewModel getManageRoomViewModel() {
        if (viewModel == null) {
            viewModel = new ManageRoomViewModel(modelFactory.getManageRoomModel());
        }
        return viewModel;
    }
    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory.getLoginModel());
        }
        return loginViewModel;
    }
}

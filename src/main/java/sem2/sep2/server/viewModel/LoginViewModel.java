package sem2.sep2.server.viewModel;

import sem2.sep2.server.model.AdminModel;

public class LoginViewModel {
    private final AdminModel model;

    public LoginViewModel(AdminModel model) {
        this.model = model;
    }

    public boolean isCorrect(String password) {
        if (password.equals(model.getPassword())) {
            return true;
        }
        return false;
    }

    public void setPassword(String password) {
        model.setPassword(password);
    }
}

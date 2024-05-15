package sem2.sep2.client.view.loginView;

import javafx.beans.property.*;
import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.register.CreateModel;

public class LoginViewModel {
    private StringProperty errorLogin, usernameLogin, passwordLogin, userType;
    private BooleanProperty signInScene;
    private LoginModel loginModel;
    private CreateModel createModel;

    public LoginViewModel(LoginModel loginModel, CreateModel createModel) {
        this.loginModel = loginModel;
        this.createModel = createModel;
        errorLogin = new SimpleStringProperty();
        usernameLogin = new SimpleStringProperty();
        passwordLogin = new SimpleStringProperty();
        signInScene = new SimpleBooleanProperty();
        userType = new SimpleStringProperty();
    }

    public void reset() {
        usernameLogin.set(null);
        passwordLogin.set(null);
        errorLogin.set(null);
    }

    public StringProperty errorLogin() {
        return errorLogin;
    }

    public StringProperty usernameLogin() {
        return usernameLogin;
    }

    public StringProperty passwordLogin() {
        return passwordLogin;
    }

    public StringProperty userType() {
        return userType;
    }

    public boolean register() {
        errorLogin.set(null);

        try {
            createModel.addUser(usernameLogin.get(), passwordLogin.get());
            //viewState.setGuestName(userNameProperty.get());
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorLogin.set(e.getMessage());
        }

        return false;
    }

    public boolean login() {
        errorLogin.set(null);

        try {
            loginModel.login(usernameLogin.get(), passwordLogin.get());
            //viewState.setGuestName(userNameProperty.get());
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorLogin.set(e.getMessage());
        }

        return false;
    }
}
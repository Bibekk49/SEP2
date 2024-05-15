package sem2.sep2.client.view.loginView;

import javafx.beans.property.*;
import sem2.sep2.client.model.login.LoginModel;

public class LoginViewModel {
    private StringProperty errorLogin, usernameLogin, passwordLogin;
    private BooleanProperty signInScene;
    private LoginModel loginModel;

    public LoginViewModel(LoginModel loginModel) {
        this.loginModel = loginModel;
        errorLogin = new SimpleStringProperty();
        usernameLogin = new SimpleStringProperty();
        passwordLogin = new SimpleStringProperty();
        signInScene = new SimpleBooleanProperty();
    }

    public void reset() {
        userNameProperty.set(null);
        passwordProperty.set(null);
        errorProperty.set(null);
        idProperty.set(0);
    }

    public StringProperty userNameProperty() {
        return userNameProperty;
    }

    public StringProperty passwordProperty() {
        return passwordProperty;
    }

    public StringProperty errorProperty() {
        return errorProperty;
    }

    public boolean register() {
        errorProperty.set(null);

        try {
            model.register(idProperty.get(), userNameProperty.get(), passwordProperty.get());
            viewState.setGuestName(userNameProperty.get());
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorProperty.set(e.getMessage());
        }

        return false;
    }

    public boolean login() {
        errorProperty.set(null);

        try {
            model.login(idProperty.get(), userNameProperty.get(), passwordProperty.get());
            viewState.setGuestName(userNameProperty.get());
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorProperty.set(e.getMessage());
        }

        return false;
    }
}
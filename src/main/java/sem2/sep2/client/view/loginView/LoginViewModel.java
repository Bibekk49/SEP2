package sem2.sep2.client.view.loginView;

import javafx.beans.property.*;
import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.register.RegisterModel;

public class LoginViewModel {
    private StringProperty errorTextProperty, usernameProperty, passwordProperty;
    private BooleanProperty signInScene;
    private LoginModel loginModel;
    private RegisterModel registerModel;

    public LoginViewModel(LoginModel loginModel, RegisterModel registerModel) {
        this.loginModel = loginModel;
        this.registerModel = registerModel;
        errorTextProperty = new SimpleStringProperty();
        usernameProperty = new SimpleStringProperty();
        passwordProperty = new SimpleStringProperty();
        signInScene = new SimpleBooleanProperty();
    }

    public void reset() {
        usernameProperty.set(null);
        passwordProperty.set(null);
        errorTextProperty.set(null);
    }

    public StringProperty errorLogin() {
        return errorTextProperty;
    }

    public StringProperty usernameLogin() {
        return usernameProperty;
    }

    public StringProperty passwordLogin() {
        return passwordProperty;
    }


    public boolean register() {
        errorTextProperty.set(null);

        try {
            registerModel.addUser(usernameProperty.get(), passwordProperty.get());
            //viewState.setGuestName(userNameProperty.get());
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorTextProperty.set(e.getMessage());
        }

        return false;
    }

    public boolean login() {
        errorTextProperty.set(null);

        try {
            loginModel.login(usernameProperty.get(), passwordProperty.get());
            //viewState.setGuestName(userNameProperty.get());
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorTextProperty.set(e.getMessage());
        }

        return false;
    }
}
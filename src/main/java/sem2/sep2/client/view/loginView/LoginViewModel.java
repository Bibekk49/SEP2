package sem2.sep2.client.view.loginView;

import javafx.beans.property.*;
import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.register.RegisterModel;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.users.Manager;
import sem2.sep2.shared.util.users.User;

public class LoginViewModel {
    private StringProperty errorTextProperty, usernameProperty, passwordProperty;
    private LoginModel loginModel;
    private RegisterModel registerModel;

    public LoginViewModel(LoginModel loginModel, RegisterModel registerModel) {
        this.loginModel = loginModel;
        this.registerModel = registerModel;
        errorTextProperty = new SimpleStringProperty();
        usernameProperty = new SimpleStringProperty();
        passwordProperty = new SimpleStringProperty();
        reset();
        errorTextProperty.set(null);
    }
    public void reset() {
        usernameProperty.set(null);
        passwordProperty.set(null);
    }

    public StringProperty errorTextProperty() {
        return errorTextProperty;
    }

    public StringProperty usernameProperty() {
        return usernameProperty;
    }

    public StringProperty passwordPorperty() {
        return passwordProperty;
    }


    public Request register() {
        try {
            return registerModel.addUser(usernameProperty.get(), passwordProperty.get());
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorTextProperty.set(e.getMessage());
            reset();
            return null;
        }
    }
    public Request login() {
        try {
            return loginModel.login(usernameProperty.get(), passwordProperty.get());
        } catch (IllegalArgumentException | IllegalStateException e) {
            errorTextProperty.set(e.getMessage());
            reset();
            return null;
        }
    }

}
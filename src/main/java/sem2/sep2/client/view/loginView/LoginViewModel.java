package sem2.sep2.client.view.loginView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.clientloginModel.ClientLoginModel;

public class LoginViewModel {
    private final ClientLoginModel model;

    private ViewState viewState;
    private StringProperty userNameProperty;
    private StringProperty passwordProperty;
    private StringProperty errorProperty;
    private IntegerProperty idProperty;

    public LoginViewModel(ClientLoginModel model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;

        this.userNameProperty = new SimpleStringProperty();
        this.passwordProperty = new SimpleStringProperty();
        this.errorProperty = new SimpleStringProperty();
        this.idProperty = new SimpleIntegerProperty();
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
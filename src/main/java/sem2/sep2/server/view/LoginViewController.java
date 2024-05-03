package sem2.sep2.server.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.server.core.ViewHandler;
import sem2.sep2.server.viewModel.LoginViewModel;
import sem2.sep2.server.core.ViewModelFactory;

import java.rmi.RemoteException;

public class LoginViewController implements ViewController {
    private LoginViewModel loginViewModel;
    private sem2.sep2.server.core.ViewHandler ViewHandler;
    private Region root;

    @FXML
    private TextField password;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) throws RemoteException {
        this.ViewHandler = viewHandler;
        this.loginViewModel = viewModelFactory.getLoginViewModel();
    }

    public void reset() {
        //
    }

    public Region getRoot() {
        return root;
    }

    public void loginButtonPressed(ActionEvent actionEvent) {
        String passwords = password.getText();
        if (loginViewModel.isCorrect(passwords)) {
            System.out.println("login successfully");
        } else {
            System.out.println("login failed");
        }
    }
}

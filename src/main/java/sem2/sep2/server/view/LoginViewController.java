package sem2.sep2.server.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.server.core.ViewHandler;
import sem2.sep2.server.viewModel.ViewModel;
import sem2.sep2.server.core.ViewModelFactory;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginViewController implements ViewController {
    private ViewModel viewModel;
    private sem2.sep2.server.core.ViewHandler viewHandler;
    private Region root;

    @FXML
    private TextField password;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,Region root) throws RemoteException,
        SQLException
    {
        this.viewHandler = viewHandler;
        this.viewModel = viewModelFactory.getLoginViewModel();
        this.root = root;
    }

    public void reset() {
        //
    }

    public Region getRoot() {
        return root;
    }
    //button here
    public void loginButtonPressed(ActionEvent actionEvent) {
        String passwords = password.getText();
        if (viewModel.isCorrect(passwords)) {
            System.out.println("login successfully");
            viewHandler.openManageRoomView();
        } else {
            System.out.println("login failed");
        }
    }
}

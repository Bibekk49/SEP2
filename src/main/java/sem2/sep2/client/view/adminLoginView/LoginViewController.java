//package sem2.sep2.client.view.adminLoginView;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Region;
//
//import java.rmi.RemoteException;
//import java.sql.SQLException;
//
//public class LoginViewController implements ViewController {
//    private LoginViewModel viewModel;
//    private sem2.sep2.server.core.ViewHandler viewHandler;
//    private Region root;
//
//    @FXML
//    private TextField password;
//
//    @Override
//    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,Region root) throws RemoteException,
//        SQLException
//    {
//        password.setText("");
//        this.viewHandler = viewHandler;
//        this.viewModel = viewModelFactory.getLoginViewModel();
//        this.root = root;
//    }
//
//    public void reset() {
//        password.setText("");
//    }
//
//    public Region getRoot() {
//        return root;
//    }
//    //button here
//    public void loginButtonPressed(ActionEvent actionEvent) {
//        String passwords = password.getText();
//        if (viewModel.isCorrect(passwords)) {
//            viewModel.alarm("Login","Login successfully");
//            viewHandler.openManageRoomView();
//        } else {
//            reset();
//            viewModel.alarm("Login","Login Failed");
//        }
//    }
//}

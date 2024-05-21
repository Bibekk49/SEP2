package sem2.sep2.client.view.loginView;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.Request;

public class LoginViewController implements ViewController {
    @FXML
    private Text errorText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;
    private Region root;

    public void reset() {
        username.setText(null);
        password.setText(null);
    }

    public Region getRoot() {
        return root;
    }

    @FXML
    public void onRegister() {
        Request result = loginViewModel.register();
        if (result != null) {
            if (result.getType().equals("User created successfully")) {
                errorText.setVisible(true);
                errorText.setText(result.getType());
                reset();
            } else {
                errorText.setVisible(true);
                errorText.setText(result.getType());
                reset();
            }
        } else {
            errorText.setVisible(true);
            errorText.setText("Username or password incorrect");
            reset();
        }
    }

    @FXML
    public void onLogin() {
        Request result = loginViewModel.login();
        if (result != null) {
            if (result.getType().equals("Login successful as Manager")) {
                viewHandler.openManagerView();
                System.out.println(result.getType());
            } else if (result.getType().equals("Login successful as Guest")) {
                viewHandler.openReserveView();
                System.out.println(result.getType());
            } else {
                errorText.setVisible(true);
                errorText.setText(result.getType());
                reset();
            }
        } else {
            errorText.setVisible(true);
            errorText.setText("Username or password incorrect");
            reset();
        }
    }

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
        this.viewHandler = viewHandler;
        this.loginViewModel = viewModelFactory.getLoginViewModel();
        this.root = root;
        username.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        password.textProperty().bindBidirectional(loginViewModel.passwordPorperty());
        errorText.textProperty().bindBidirectional(loginViewModel.errorTextProperty());
    }
}

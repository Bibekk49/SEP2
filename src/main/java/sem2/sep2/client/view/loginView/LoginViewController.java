package sem2.sep2.client.view.loginView;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.client.core.ViewModelFactory;

import java.rmi.RemoteException;

public class LoginViewController implements ViewController
{
  @FXML
  private Text errorText;
  @FXML private TextField guestNameField;
  @FXML private PasswordField passwordField;

  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;
  private Region root;



  public void reset()
  {
    loginViewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void onRegister()
  {
    boolean success = loginViewModel.register();

    if (success)
      System.out.println("User registered" );
  }

  @FXML public void onLogin()
  {
    boolean success = loginViewModel.login();

    if (success)
      System.out.println("User logged in");
      viewHandler.openReserveView();
  }

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) throws RemoteException {
    this.viewHandler = viewHandler;
    this.loginViewModel = viewModelFactory.getLoginViewModel();
    this.root = root;

    errorText.textProperty().bind(loginViewModel.errorLogin());
    guestNameField.textProperty().bindBidirectional(loginViewModel.usernameLogin());
    passwordField.textProperty().bindBidirectional(loginViewModel.passwordLogin());
  }

}

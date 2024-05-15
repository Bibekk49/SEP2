package sem2.sep2.client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.viewModel.LoginViewModel;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.shared.networking.LoginService;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class LoginViewController implements ViewController
{
  private sem2.sep2.client.core.ViewHandler viewHandler;
  private LoginViewModel loginViewModel;
  private Region root;
  private LoginService loginService;
  @FXML
  private TextField username;
  @FXML
  private TextField password;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
      Region root, LoginService loginService) throws RemoteException {
    this.viewHandler = viewHandler;
    this.loginViewModel=viewModelFactory.getLoginViewModel();
    this.root = root;
    this.loginService = loginService;


    reset();
  }
  @Override
  public void reset(){
    username.setText("");
    password.setText("");
  }
  public void LoginButtonPressed(ActionEvent actionEvent)
      throws RemoteException, SQLException
  {
    String username_ = username.getText();
    String password_ = password.getText();
    if(loginService.login(username_,password_)){
      viewHandler.openReserveView();
    }else{
      reset();
    }
  }

}

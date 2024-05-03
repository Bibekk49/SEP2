package sem2.sep2.client.view.loginView;

import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.client.viewModel.LoginViewModel;
import sem2.sep2.client.core.ViewModelFactory;

import java.rmi.RemoteException;

public class LoginViewController implements ViewController
{
  private sem2.sep2.client.core.ViewHandler ViewHandler;
  private LoginViewModel loginViewModel;
  private Region root;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
      Region root) throws RemoteException {
    this.ViewHandler = viewHandler;
    this.loginViewModel=viewModelFactory.getLoginViewModel();
    this.root = root;
  }
}

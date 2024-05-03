package sem2.sep2.client.view.loginView;

import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.client.viewModel.LoginViewModel;
import sem2.sep2.client.core.ViewModelFactory;

import java.rmi.RemoteException;

public class LoginViewController implements ViewController
{
  private sem2.sep2.client.core.ViewHandler ViewHandler;
  private LoginViewModel loginViewModel;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) throws RemoteException {
    this.ViewHandler = viewHandler;
    this.loginViewModel=viewModelFactory.getLoginViewModel();
  }
}

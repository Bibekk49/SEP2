package sem2.sep2.client.view.contactView;

import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.client.view.loginView.LoginViewModel;

import java.rmi.RemoteException;

public class ContactViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ContactViewModel contactViewModel;
  private Region root;
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root)throws RemoteException
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.contactViewModel = viewModelFactory.getContactViewModel();
  }
  @Override
  public void reset(){

  }
}

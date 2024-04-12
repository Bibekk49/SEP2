package sem2.sep2.server.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import sem2.sep2.server.viewModel.ViewModelFactory;
import java.io.IOException;

public class ViewFactory
{
  private LoginViewController loginViewController;
  private final ViewHandler viewHandler;
  private final ViewModelFactory viewModelFactory;
  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory){
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.loginViewController = null;
  }
  public Region loadLoginView(){
    if(loginViewController==null){
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/sem2.sep2.server.view/ManagerLogin.fxml"));
      try{
        Region root = loader.load();
        loginViewController = loader.getController();
        loginViewController.init(viewHandler,viewModelFactory.getAdminViewModel(),root);
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    loginViewController.reset();
    return loginViewController.getRoot();
  }
}

package sem2.sep2.client.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import sem2.sep2.client.viewModel.ClientViewModelFactory;

import java.io.IOException;

public class ClientViewFactory
{
  private ClientLoginViewController clientLoginViewController;
  private final ClientViewHandler clientViewHandler;
  private final ClientViewModelFactory clientViewModelFactory;
  public ClientViewFactory(ClientViewHandler clientViewHandler, ClientViewModelFactory clientViewModelFactory){
    this.clientViewHandler = clientViewHandler;
    this.clientViewModelFactory = clientViewModelFactory;
    this.clientLoginViewController = null;
  }
  public Region loadLoginView(){
    if(clientLoginViewController == null){
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(
          "/sem2.sep2.client.view/GuestLogin.fxml"));
      try{
        Region root = loader.load();
        clientLoginViewController = loader.getController();
        clientLoginViewController.init(clientViewHandler,clientViewModelFactory.getClientLoginViewModel(),root);
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    clientLoginViewController.reset();
    return clientLoginViewController.getRoot();
  }
}

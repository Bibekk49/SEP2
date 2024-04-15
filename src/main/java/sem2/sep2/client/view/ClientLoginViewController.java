package sem2.sep2.client.view;

import javafx.scene.layout.Region;
import sem2.sep2.client.viewModel.ClientLoginViewModel;

public class ClientLoginViewController
{
  private ClientViewHandler clientViewHandler;
  private ClientLoginViewModel clientLoginViewModel;
  private Region root;
  public void init(ClientViewHandler clientViewHandler, ClientLoginViewModel clientLoginViewModel,
      Region root){
    this.clientViewHandler = clientViewHandler;
    this.clientLoginViewModel = clientLoginViewModel;
    this.root = root;
  }
  public void reset(){
    //
  }
  public Region getRoot(){
    return root;
  }
}

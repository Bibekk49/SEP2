package sem2.sep2.client.view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sem2.sep2.client.viewModel.ClientViewModelFactory;


public class ClientViewHandler
{
  Stage stage;
  private final Scene currentScene;
  private final ClientViewFactory clientViewFactory;
  public ClientViewHandler(ClientViewModelFactory clientViewModelFactory){
    this.clientViewFactory = new ClientViewFactory(this,clientViewModelFactory);
    this.currentScene = new Scene(new Region());
  }
  public void startLogin(Stage stage){
    this.stage = stage;
    openLoginView();
  }
  public void openLoginView(){
    Region root =clientViewFactory.loadLoginView();
    currentScene.setRoot(root);
    if(root.getUserData()==null){
      stage.setTitle(" ");
    }else{
      stage.setTitle(root.getUserData().toString());
    }
    stage.setScene(currentScene);
    stage.sizeToScene();
    stage.show();
  }
}

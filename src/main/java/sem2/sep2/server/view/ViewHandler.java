package sem2.sep2.server.view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sem2.sep2.server.viewModel.ViewModelFactory;

public class ViewHandler
{
  Stage stage;
  private final Scene currentScene;
  private final ViewFactory viewFactory;
  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewFactory = new ViewFactory(this,viewModelFactory);
    this.currentScene = new Scene(new Region());
  }
  public void startLogin(Stage stage){
    this.stage = stage;
    openLoginView();
  }
  public void openLoginView(){
    Region root =viewFactory.loadLoginView();
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

package sem2.sep2;

import javafx.application.Application;
import javafx.stage.Stage;
import sem2.sep2.client.model.ClientModel;
import sem2.sep2.client.model.ClientModelManager;
import sem2.sep2.client.view.ClientViewHandler;
import sem2.sep2.client.viewModel.ClientViewModelFactory;

public class testClient extends Application
{
  @Override
  public void start(Stage stage){
    ClientModel model = new ClientModelManager();
    ClientViewModelFactory clientViewModelFactory = new ClientViewModelFactory(model);
    ClientViewHandler clientViewHandler = new ClientViewHandler(clientViewModelFactory);
    clientViewHandler.openLoginView();
  }
  public static void main(String[] args){
    launch(args);
  }
}

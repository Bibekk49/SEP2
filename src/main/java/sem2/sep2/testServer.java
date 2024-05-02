package sem2.sep2;

import javafx.application.Application;
import javafx.stage.Stage;
import sem2.sep2.server.model.AdminModel;
import sem2.sep2.server.model.AdminModelManager;
import sem2.sep2.server.view.ViewHandler;
import sem2.sep2.server.viewModel.ViewModelFactory;

import java.sql.Connection;

import static sem2.sep2.UserDao.connection;

public class testServer extends Application
{
  @Override
  public void start(Stage stage){
    AdminModel model = new AdminModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.startLogin(stage);
  }
  public static void main(String[] args){
    launch(args);
  }
}
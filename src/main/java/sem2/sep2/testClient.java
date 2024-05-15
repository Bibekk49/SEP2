package sem2.sep2;

import javafx.application.Application;
import javafx.stage.Stage;
import sem2.sep2.client.core.ModelFactory;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.shared.networking.LoginService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class testClient extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            ModelFactory modelFactory = new ModelFactory();
            ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
            ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
            viewHandler.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Application.launch(testClient.class);
    }

}
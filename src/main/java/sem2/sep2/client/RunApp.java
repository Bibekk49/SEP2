package sem2.sep2.client;

import javafx.application.Application;
import javafx.stage.Stage;
import sem2.sep2.client.core.ClientFactory;
import sem2.sep2.client.core.ModelFactory;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;

public class RunApp extends Application {
    ClientFactory clientFactory = new ClientFactory();
    @Override
    public void start(Stage stage) throws Exception {
        try {
            ModelFactory modelFactory = new ModelFactory(clientFactory);
            ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
            ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
            viewHandler.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Application.launch(RunApp.class);
    }

}
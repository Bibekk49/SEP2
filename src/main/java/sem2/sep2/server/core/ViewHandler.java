package sem2.sep2.server.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sem2.sep2.server.view.ViewController;

import java.io.IOException;
import java.rmi.RemoteException;

public class ViewHandler {
    private Stage stage;
    private final ViewModelFactory viewModelFactory;
    private Scene loginScene;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
    }

    public void start() {
        stage = new Stage();
        openLoginView();
    }

    private Parent loadFXMLFile(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ViewController ctrl = loader.getController();
        try {
            ctrl.init(this, viewModelFactory);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return root;
    }

    public void openLoginView() {
        if (loginScene == null) {
            Parent root = loadFXMLFile("/sem2.sep2.server.view/ManagerLogin.fxml");
            loginScene = new Scene(root);
            stage.setTitle("Login");
        }
        stage.setScene(loginScene);
        stage.show();
    }

    public void openManageRoomView() {
        if (loginScene == null) {
            Parent root = loadFXMLFile("/sem2.sep2.server.view/ManageRoom.fxml");
            loginScene = new Scene(root);
            stage.setTitle("Login");
        }
        stage.setScene(loginScene);
        stage.show();
    }
}

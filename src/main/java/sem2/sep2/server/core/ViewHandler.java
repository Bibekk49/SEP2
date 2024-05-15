package sem2.sep2.server.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sem2.sep2.server.view.ManageRoomViewController;
import sem2.sep2.server.view.ViewController;
import sem2.sep2.shared.networking.LoginService;
import sem2.sep2.shared.networking.LoginServiceImpl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

public class ViewHandler {
    private Stage stage;
    private final ViewModelFactory viewModelFactory;
    private Scene loginScene;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
    }

    public void start() {
        try{
            LoginService loginService = new LoginServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("LoginService",loginService);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        stage = new Stage();
        openLoginView();
    }

    private Region loadFXMLFile(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Region root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ViewController ctrl = loader.getController();
        try {
            ctrl.init(this, viewModelFactory,root);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e)
        {
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

        stage.close();
        loginScene = null;
        Parent root = loadFXMLFile("/sem2.sep2.server.view/ManageRoom.fxml");
        loginScene = new Scene(root);
        stage.setTitle("ManageRoom");
        stage.setScene(loginScene);
        stage.show();
    }
}

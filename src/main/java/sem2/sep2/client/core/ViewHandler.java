package sem2.sep2.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.networking.LoginService;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ViewHandler {
    private Stage stage;
    private final ViewModelFactory viewModelFactory;
    private Scene loginScene;
    private Scene reserveScene;
    private LoginService loginService;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
    }

    public void start() {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            loginService = (LoginService) registry.lookup("LoginService");
        }catch (Exception e){
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
            ctrl.init(this, viewModelFactory,root,loginService);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return root;
    }

    public void openLoginView() {
        if (loginScene == null) {
            Region root = loadFXMLFile("/sem2.sep2.client.view/GuestLogin.fxml");
            loginScene = new Scene(root);
            stage.setTitle("Login");
        }
        stage.setScene(loginScene);
        stage.show();
    }
    public void openReserveView(){
        if (reserveScene == null) {
            Region root = loadFXMLFile("/sem2.sep2.client.view/ReserveGUI.fxml");
            reserveScene = new Scene(root);
            stage.setTitle("Reserve");
        }
        stage.setScene(reserveScene);
        stage.show();
    }
}

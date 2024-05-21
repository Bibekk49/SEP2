package sem2.sep2.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sem2.sep2.client.view.ViewController;

import java.io.IOException;
import java.rmi.RemoteException;


public class ViewHandler {
    private Stage stage;
    private final ViewModelFactory viewModelFactory;
    private Scene Scene;
    private Scene profileScene;
    private Scene contactScene;
    private Scene historyScene;
    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
    }

    public void start() {
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
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return root;
    }

    public void openLoginView() {
        if (Scene == null) {
            Region root = loadFXMLFile("/sem2.sep2.client.view/Login.fxml");
            Scene = new Scene(root);
            stage.setTitle("Login");
        }

        stage.setScene(Scene);
        stage.show();
    }

    public void openReserveView() {
        Region root = loadFXMLFile("/sem2.sep2.client.view/ReserveGUI.fxml");
        Scene scene = new Scene(root);
        stage.setTitle("Reserve");
        stage.setScene(scene);
        stage.show();
    }
    public void openContactView() {
        Region root = loadFXMLFile("/sem2.sep2.client.view/Contact.fxml");
        contactScene = new Scene(root);
        Stage contactStage = new Stage();
        contactStage.setTitle("Contact");
        contactStage.setScene(contactScene);
        contactStage.show();
    }
    public void openManagerView()
    {
        Region root = loadFXMLFile("/sem2.sep2.server.view/ManageRoom.fxml");
        Scene = new Scene(root);
        stage.setTitle("Manager");
        stage.setScene(Scene);
        stage.show();
    }
    public void openProfileView(){
        Region root = loadFXMLFile("/sem2.sep2.client.view/Profile.fxml");
        profileScene = new Scene(root);
        Stage profileStage = new Stage();
        profileStage.setTitle("Profile");
        profileStage.setScene(profileScene);
        profileStage.show();
    }
    public void openHistoryView(){
        Region root = loadFXMLFile("/sem2.sep2.client.view/History.fxml");
        historyScene = new Scene(root);
        Stage historyStage = new Stage();
        historyStage.setTitle("History");
        historyStage.setScene(historyScene);
        historyStage.show();
    }
}

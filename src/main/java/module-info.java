module sem2.sep2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens sem2.sep2 to javafx.fxml;
    opens sem2.sep2.server.view to javafx.fxml;
    opens sem2.sep2.client.view to javafx.fxml;
    exports sem2.sep2;
    opens sem2.sep2.client.core to javafx.fxml;
    opens sem2.sep2.server.core to javafx.fxml;
    opens sem2.sep2.client.view.loginView to javafx.fxml;
}
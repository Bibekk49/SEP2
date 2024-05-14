module sem2.sep2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    requires java.sql;
    requires org.postgresql.jdbc;

    opens sem2.sep2 to javafx.fxml;
    opens sem2.sep2.server.view to javafx.fxml;
    opens sem2.sep2.client.view to javafx.fxml;
    exports sem2.sep2;
    opens sem2.sep2.client.core to javafx.fxml;
    opens sem2.sep2.server.core to javafx.fxml;
    opens sem2.sep2.client.view.loginView to javafx.fxml;
  exports sem2.sep2.server.database;
  opens sem2.sep2.server.database to javafx.fxml;
    opens sem2.sep2.server.view.loginView to javafx.fxml;
    opens sem2.sep2.server.view.manageRoomView to javafx.fxml;
}
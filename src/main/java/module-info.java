module sem2.sep2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    requires java.sql;
    requires org.postgresql.jdbc;

    opens sem2.sep2.client.view.reserveView to javafx.fxml;

    opens sem2.sep2 to javafx.fxml;
    opens sem2.sep2.server.view to javafx.fxml;
    opens sem2.sep2.client.view to javafx.fxml;

    opens sem2.sep2.client.core to javafx.fxml;
    opens sem2.sep2.client.view.loginView to javafx.fxml;

    opens sem2.sep2.server.database to javafx.fxml;
    opens sem2.sep2.client.view.manageRoomView to javafx.fxml;
    opens sem2.sep2.client.view.adminLoginView to javafx.fxml;

    exports sem2.sep2.client.view.contactView to javafx.fxml;
    exports sem2.sep2.server.database;
    exports sem2.sep2;
    exports sem2.sep2.shared.networking.serverInterfaces to java.rmi;

}
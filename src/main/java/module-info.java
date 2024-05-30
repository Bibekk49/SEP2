module sem2.sep2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.desktop;

    opens sem2.sep2.client.view.reserveView to javafx.fxml;
    opens sem2.sep2.client.view.contactView to javafx.fxml;
    opens sem2.sep2.client.view.profileView to javafx.fxml;
    opens sem2.sep2.client.view.loginView to javafx.fxml;
    opens sem2.sep2.client.view.manageRoomView to javafx.fxml;
    opens sem2.sep2.client.view.historyView to javafx.fxml;


    opens sem2.sep2.server.view to javafx.fxml;
    opens sem2.sep2.client.view to javafx.fxml;
    opens sem2.sep2.client.core to javafx.fxml;
    opens sem2.sep2.server.database to javafx.fxml;

    opens sem2.sep2.shared.util.room to javafx.base;

    exports sem2.sep2.server.database;
    exports sem2.sep2.shared.networking.serverInterfaces to java.rmi;
    exports sem2.sep2.client;
    opens sem2.sep2.client to javafx.fxml;

}
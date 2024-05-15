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

    exports sem2.sep2.server.Dao;
    exports sem2.sep2.shared.networking;
    opens sem2.sep2.shared.util to javafx.base;
    opens sem2.sep2.server.Dao to javafx.fxml;
}
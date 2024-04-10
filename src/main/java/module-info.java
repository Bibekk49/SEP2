module sem2.sep2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens sem2.sep2 to javafx.fxml;
    exports sem2.sep2;
}
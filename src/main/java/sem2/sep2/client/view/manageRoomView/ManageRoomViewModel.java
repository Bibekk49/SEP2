package sem2.sep2.client.view.manageRoomView;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import sem2.sep2.server.model.room.RoomModel;
public class ManageRoomViewModel
{
    private final RoomModel model;

    public ManageRoomViewModel(RoomModel model) {
        this.model = model;
    }

    public void alarm(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }
    public boolean confirm(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Please confirm all properties here.Improper operations may cause problems. ");
        alert.setContentText("Are you sure you want to continue?");

        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

        if (result == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isIntDouble(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e1) {
            try {
                Double.parseDouble(input);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }
}

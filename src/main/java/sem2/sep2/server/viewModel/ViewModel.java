package sem2.sep2.server.viewModel;

import javafx.scene.control.Alert;
import sem2.sep2.server.model.AdminModel;

public class ViewModel
{
    private final AdminModel model;

    public ViewModel(AdminModel model) {
        this.model = model;
    }
    //login
    public boolean isCorrect(String password) {
        if (password.equals(model.getPassword())) {
            return true;
        }
        return false;
    }

    public void setPassword(String password) {
        model.setPassword(password);
    }

    //manageRoom
    public static void alarm(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
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
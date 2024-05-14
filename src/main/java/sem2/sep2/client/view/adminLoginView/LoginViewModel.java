package sem2.sep2.client.view.adminLoginView;

import javafx.scene.control.Alert;
import sem2.sep2.server.model.managerLoginModel.ManagerLoginModel;

public class LoginViewModel {
    private ManagerLoginModel model;;
    public LoginViewModel (ManagerLoginModel model) {
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
    public void alarm(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }
}


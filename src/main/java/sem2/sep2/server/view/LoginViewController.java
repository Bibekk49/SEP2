package sem2.sep2.server.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.server.viewModel.AdminViewModel;

public class LoginViewController
{
  private ViewHandler viewHandler;
  private AdminViewModel adminViewModel;
  private Region root;

  @FXML
  private TextField password;

  public void init(ViewHandler viewHandler, AdminViewModel adminViewModel,Region root){
    this.viewHandler = viewHandler;
    this.adminViewModel = adminViewModel;
    this.root = root;
  }
  public void reset(){
    //
  }
  public Region getRoot(){
    return root;
  }
  public void loginButtonPressed(ActionEvent actionEvent){
    String passwords = password.getText();
    if(adminViewModel.isCorrect(passwords)){
      System.out.println("login successfully");
    }else{
      System.out.println("login failed");
    }
  }
}

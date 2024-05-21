package sem2.sep2.client.view.profileView;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;

import javafx.event.ActionEvent;

public class ProfileViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ProfileViewModel profileViewModel;
  private Region root;
  @FXML
  private TextField UserName;
  @FXML
  private TextField newUserName;
  @FXML
  private TextField userNameChangePassword;
  @FXML
  private TextField newPassword;
  @FXML
  private TextField again;
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root){
    this.viewHandler = viewHandler;
    this.profileViewModel = viewModelFactory.getProfileViewModel();
    this.root = root;

    this.UserName.textProperty().bindBidirectional(profileViewModel.getUserName());
    this.newUserName.textProperty().bindBidirectional(profileViewModel.getNewUserName());
    this.userNameChangePassword.textProperty().bindBidirectional(profileViewModel.getUserNameChangePassword());
    this.newPassword.textProperty().bindBidirectional(profileViewModel.getNewPassword());
    this.again.textProperty().bindBidirectional(profileViewModel.getAgain());
  }
  @Override
  public void reset(){
    profileViewModel.reset();
  }
  public void changeUserNamePressed(ActionEvent actionEvent){
    if(profileViewModel.changeUserName()){
      System.out.println("Change failed");
    }
    System.out.println("Change successfully");
    reset();
  }
  public void changeNewPasswordPressed(ActionEvent actionEvent){
    if(profileViewModel.changePassword()){
      System.out.println("Change failed");
    }
    System.out.println("Change successfully");
    reset();
  }
}

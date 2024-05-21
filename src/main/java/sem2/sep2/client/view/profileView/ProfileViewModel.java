package sem2.sep2.client.view.profileView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.register.CreateModel;

public class ProfileViewModel
{
  private CreateModel createModel;
  private StringProperty UserName,newUserName,userNameChangePassword,newPassword,again;
  public ProfileViewModel(CreateModel createModel){
    this.createModel = createModel;
    UserName = new SimpleStringProperty();
    newUserName = new SimpleStringProperty();
    userNameChangePassword = new SimpleStringProperty();
    newPassword = new SimpleStringProperty();
    again = new SimpleStringProperty();
  }
  public StringProperty getUserName(){
    return UserName;
  }
  public StringProperty getNewUserName(){
    return newUserName;
  }
  public StringProperty getUserNameChangePassword(){
    return userNameChangePassword;
  }
  public StringProperty getNewPassword(){
    return newPassword;
  }
  public StringProperty getAgain(){
    return again;
  }
  public boolean changeUserName(){
    return createModel.changeUsername(UserName.get(),newUserName.get()).equals("Username changed successfully");
  }
  public boolean changePassword(){
    if(!newPassword.get().equals(again.get())){
      return false;
    }

    return createModel.changePassword(userNameChangePassword.get(), newPassword.get()).equals("Password changed successfully");
  }
  public void reset(){
    UserName.set("");
    newUserName.set("");
    userNameChangePassword.set("");
    newPassword.set("");
    again.set("");
  }
}

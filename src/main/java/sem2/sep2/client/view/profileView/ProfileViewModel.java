package sem2.sep2.client.view.profileView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.register.RegisterModel;

public class ProfileViewModel
{
  private RegisterModel createModel;
  private StringProperty UserName,newUserName,userNameChangePassword,newPassword,again;
  public ProfileViewModel(RegisterModel createModel){
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
    boolean change = createModel.changeUsername(UserName.get(),newUserName.get()).getType().equals("Username changed successfully");
    return change;
  }
  public boolean changePassword(){
    if(!newPassword.get().equals(again.get())){
      return false;
    }
    return createModel.changePassword(userNameChangePassword.get(), newPassword.get()).getType().equals("Password changed successfully");
  }
  public void reset(){
    UserName.set(null);
    newUserName.set(null);
    userNameChangePassword.set(null);
    newPassword.set(null);
    again.set(null);
  }
}

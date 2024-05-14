package sem2.sep2.server.model.managerLoginModel;
import sem2.sep2.shared.util.users.Manager;

public class ManagerLoginModelImpl implements ManagerLoginModel
{
  private Manager admin;
  @Override
  public void setPassword(String password) {
    admin.setPassword(password);
  }

  @Override
  public String getPassword() {
    return admin.getPassword();
  }

  @Override
  public void login(String password) {
    admin= new Manager(password);
  }
}

package sem2.sep2.server.model;

public class AdminModelImpl implements AdminModel
{
  private Admin admin;
  public AdminModelImpl(){
    admin = new Admin("admin");
  }
  @Override
  public void setPassword(String password){
    admin.setPassword(password);
  }
  @Override
  public String getPassword(){
    return admin.getPassword();
  }
}

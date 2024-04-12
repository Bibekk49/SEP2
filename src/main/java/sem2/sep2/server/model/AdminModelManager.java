package sem2.sep2.server.model;

public class AdminModelManager implements AdminModel
{
  Admin admin;
  public AdminModelManager(){
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

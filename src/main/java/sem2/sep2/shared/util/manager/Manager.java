package sem2.sep2.shared.util.manager;

public class Manager
{
  private String password;
  public Manager(String password){
    this.password = password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public String getPassword(){
    return password;
  }

}
package sem2.sep2.server.model;

public class Admin
{
  String password;
  public Admin(String password){
    this.password = password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public String getPassword(){
    return password;
  }
}
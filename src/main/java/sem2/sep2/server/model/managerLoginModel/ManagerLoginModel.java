package sem2.sep2.server.model.managerLoginModel;

public interface ManagerLoginModel {
    void setPassword(String password);

    String getPassword();

    void login(String password);

}

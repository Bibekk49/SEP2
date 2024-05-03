package sem2.sep2.client.core;

import sem2.sep2.client.model.loginModel.LoginModel;
import sem2.sep2.client.model.loginModel.LoginModelImpl;

public class ModelFactory {
    private LoginModelImpl loginModelImpl;
    public LoginModel getLoginViewModel() {
        if (loginModelImpl ==null){
            loginModelImpl =new LoginModelImpl();
        }
        return loginModelImpl;
    }
}

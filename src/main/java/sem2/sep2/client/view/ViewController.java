package sem2.sep2.client.view;

import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.shared.networking.LoginService;

import java.rmi.RemoteException;

public interface ViewController {

    void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
        Region root, LoginService loginService) throws RemoteException;
    void reset();
}

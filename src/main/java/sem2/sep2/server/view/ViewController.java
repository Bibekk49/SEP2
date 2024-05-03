package sem2.sep2.server.view;

import javafx.scene.layout.Region;
import sem2.sep2.server.core.ViewHandler;
import sem2.sep2.server.core.ViewModelFactory;

import java.rmi.RemoteException;

public interface ViewController {
    void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
        Region root) throws RemoteException;
}

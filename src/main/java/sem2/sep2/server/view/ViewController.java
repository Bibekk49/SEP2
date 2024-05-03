package sem2.sep2.server.view;

import sem2.sep2.server.core.ViewHandler;
import sem2.sep2.server.core.ViewModelFactory;

import java.rmi.RemoteException;

public interface ViewController {
    void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) throws RemoteException;
}

package sem2.sep2.client.view;

import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;

import java.rmi.RemoteException;

public interface ViewController {

    void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) throws RemoteException;
}

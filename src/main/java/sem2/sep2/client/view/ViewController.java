package sem2.sep2.client.view;

import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;


public interface ViewController {

    void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
              Region root);
    void reset();
}

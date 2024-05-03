package sem2.sep2.server.view;

import javafx.scene.layout.Region;
import sem2.sep2.server.core.ViewHandler;
import sem2.sep2.server.viewModel.LoginViewModel;

public class ManageRoomViewController {
    private ViewHandler viewHandler;
    private LoginViewModel adminViewModel;
    private Region root;

    public void init(ViewHandler viewHandler, LoginViewModel adminViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.adminViewModel = adminViewModel;
        this.root = root;
    }

    public void reset() {
        //
    }

    public Region getRoot() {
        return root;
    }
}
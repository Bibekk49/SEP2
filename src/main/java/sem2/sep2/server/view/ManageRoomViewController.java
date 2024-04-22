package sem2.sep2.server.view;

import javafx.scene.layout.Region;
import sem2.sep2.server.viewModel.AdminViewModel;

public class ManageRoomViewController
{
  private ViewHandler viewHandler;
  private AdminViewModel adminViewModel;
  private Region root;
  public void init(ViewHandler viewHandler, AdminViewModel adminViewModel,Region root){
    this.viewHandler = viewHandler;
    this.adminViewModel = adminViewModel;
    this.root = root;
  }
  public void reset(){
    //
  }
  public Region getRoot(){
    return root;
  }
}
package sem2.sep2.client.view.manageRoomView;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;

import javax.swing.text.View;

public class editRoomViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ManageRoomViewModel manageRoomViewModel;
  public Region root;

  @FXML
  private TextField roomNumberEdit;
  @FXML
  private TextField priceEdit;
  @FXML
  private ChoiceBox<String> roomTypeEdit;
  @FXML
  private Text errorTextEdit;


  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
    this.viewHandler = viewHandler;
    this.manageRoomViewModel = viewModelFactory.getManageRoomViewModel();
    this.root = root;

    this.bindProperty();
  }
  private void bindProperty(){
    roomNumberEdit.textProperty().bindBidirectional(manageRoomViewModel.getRoomNumberEdit());
    priceEdit.textProperty().bindBidirectional(manageRoomViewModel.getPriceEdit());
    roomTypeEdit.setItems(manageRoomViewModel.getRoomTypes());
    roomTypeEdit.valueProperty().bindBidirectional(manageRoomViewModel.getRoomTypeEdit());
    errorTextEdit.textProperty().bind(manageRoomViewModel.getErrorEdit());
  }
  @Override
  public void reset(){

  }
  public void saveButtonClicked() {

    manageRoomViewModel.editRoom();
    manageRoomViewModel.refresh();

  }

  public void backButtonClicked() {

  }
}

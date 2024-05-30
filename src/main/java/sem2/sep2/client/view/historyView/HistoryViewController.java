package sem2.sep2.client.view.historyView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.reservation.Reservation;

import java.sql.Date;

public class HistoryViewController implements ViewController
{
  private ViewHandler viewHandler;
  private HistoryViewModel historyViewModel;
  private Region root;
  @FXML
  private TableView<Reservation> history;
  @FXML
  private TableColumn<Reservation, Integer> roomNumber;
  @FXML
  private TableColumn<Reservation, Date> checkInDate;
  @FXML
  private TableColumn<Reservation, Date> checkOutDate;


  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root){
    this.viewHandler = viewHandler;
    this.historyViewModel = viewModelFactory.getHistoryViewModel();
    this.root = root;
    bindProperty();
  }
  private void bindProperty(){
    roomNumber.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("roomNumber"));
    checkInDate.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("checkInDate"));
    checkOutDate.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("checkOutDate"));
    history.setItems(historyViewModel.getReserveHistory(viewHandler.getGuest()));
    history.getSelectionModel().selectedItemProperty().addListener((obs, oldVal,newVal) -> historyViewModel.selectedRoomProperty().set(newVal));

  }
  @Override
  public void reset(){
    history.setItems(historyViewModel.getReserveHistory(viewHandler.getGuest()));
  }
  public Region getRoot() {
    return root;
  }
  @FXML
  private void CancelButtonPressed(ActionEvent actionEvent){
    historyViewModel.cancel();
  }
  @FXML
  private void CheckIn(ActionEvent actionEvent){
//    historyViewModel.checkIn();
  }
  @FXML
  private void CheckOut(ActionEvent actionEvent){
//    historyViewModel.checkOut();
  }

}
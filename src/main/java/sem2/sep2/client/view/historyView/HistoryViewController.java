package sem2.sep2.client.view.historyView;

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
  }
  private void bindProperty(){
    roomNumber.setCellFactory(new PropertyValueFactory<>("roomNumber"));
    history.setItems();

  }
  @Override
  public void reset(){

  }

}
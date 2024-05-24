package sem2.sep2.client.view.historyView;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.users.Guest;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class HistoryViewModel
{
  private RoomModel roomModel;
  private ObservableList<Reservation> reserveHistory;
  private PropertyChangeSupport support;
  public HistoryViewModel(RoomModel roomModel){
    this.roomModel = roomModel;
    this.reserveHistory = FXCollections.observableArrayList();
    this.support = new PropertyChangeSupport(this);
    roomModel.addPropertyChangeListener("ReservationHistoryUpdated", this::updateHistory);
  }
  public void getHistory(){
    ObservableList<Reservation> history = FXCollections.observableArrayList(roomModel.getHistory());
    reserveHistory.setAll(history);
  }
  public ObservableList<Reservation> getReserveHistory(Guest guest){
    ReservationList reservationList = (ReservationList) roomModel.getCurrentReservationsByGuest(guest.getUsername()).getObject();
    reserveHistory.addAll(reservationList.getAllReservations());
    return reserveHistory;
  }
  private void updateHistory(PropertyChangeEvent event) {
    reserveHistory.setAll((ObservableList<Reservation>) event.getNewValue());
  }
  public void cancel(){

  }
}

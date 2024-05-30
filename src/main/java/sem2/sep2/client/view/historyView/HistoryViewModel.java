package sem2.sep2.client.view.historyView;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.users.Guest;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class HistoryViewModel
{
  private RoomModel roomModel;
  private StringProperty error;
  private ObservableList<Reservation> reserveHistory;
  private ObjectProperty<Reservation> selectedRoom = new SimpleObjectProperty<>();
  private Guest guest;
  public HistoryViewModel(RoomModel roomModel){
    this.roomModel = roomModel;
    this.reserveHistory = FXCollections.observableArrayList();
    this.error = new SimpleStringProperty();
    reserveHistory.clear();
  }
  public ObservableList<Reservation> getReserveHistory(Guest guest){
    this.guest = guest;
    ReservationList reservationList = (ReservationList) roomModel.getCurrentReservationsByGuest(guest.getUsername()).getObject();
    reserveHistory.clear();
    reserveHistory.addAll(reservationList.getAllReservations());
    return reserveHistory;
  }
  public void cancel(){
    reserveHistory.clear();
    getReserveHistory(guest);
  }
  public void reset(){

  }
  public void checkIn(){
    roomModel.changeRoomState(selectedRoom.get().getRoomNumber(),"Occupied");
    reserveHistory.remove(selectedRoom.get());
    reserveHistory.clear();
    getReserveHistory(guest);
    error.set("Successfully checked in!");
  }
  public void checkOut(){
    roomModel.changeRoomState(selectedRoom.get().getRoomNumber(),"Available");
    reserveHistory.remove(selectedRoom.get());
    reserveHistory.clear();
    getReserveHistory(guest);
    error.set("Successfully checked out!");
  }
  public ObjectProperty<Reservation> selectedRoomProperty() {
    return selectedRoom;
  }

  public StringProperty errorProperty() {
    return error;
  }

}

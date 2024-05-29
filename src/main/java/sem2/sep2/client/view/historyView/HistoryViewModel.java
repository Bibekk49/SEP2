package sem2.sep2.client.view.historyView;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
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
  private ObservableList<Reservation> reserveHistory;
  private ObjectProperty<Reservation> selectedRoom = new SimpleObjectProperty<>();
  public HistoryViewModel(RoomModel roomModel){
    this.roomModel = roomModel;
    this.reserveHistory = FXCollections.observableArrayList();
  }
  public ObservableList<Reservation> getReserveHistory(Guest guest){
    ReservationList reservationList = (ReservationList) roomModel.getCurrentReservationsByGuest(guest.getUsername()).getObject();
    reserveHistory.addAll(reservationList.getAllReservations());
    return reserveHistory;
  }
  public void cancel(){

  }
  public void reset(){

  }
  public void checkIn(){
    Reservation reservation = selectedRoom.get();
    Room room = reservation.searchRoomById(reservation.getRoomNumber());
    room.checkIn();
    roomModel.updateRoom(room);
  }
  public void checkOut(){
    Reservation reservation = selectedRoom.get();
    Room room = reservation.searchRoomById(reservation.getRoomNumber());
    room.checkOut();
    roomModel.updateRoom(room);
  }
  public ObjectProperty<Reservation> selectedRoomProperty() {
    return selectedRoom;
  }
}

package sem2.sep2.client.view.reserveView;

import javafx.beans.property.*;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.RoomList;

import java.sql.Date;
import java.time.LocalDate;

public class ReserveViewModel {
  private RoomModel reserveModel;
  private StringProperty roomType,roomNumber;
  private ObjectProperty<LocalDate> checkInDatePicker,checkOutDatePicker;
  public ReserveViewModel(RoomModel reserveModel)
  {
    this.reserveModel = reserveModel;
    checkInDatePicker = new SimpleObjectProperty<>();
    checkOutDatePicker = new SimpleObjectProperty<>();
    roomType = new SimpleStringProperty();
    roomNumber = new SimpleStringProperty();
  }
  public Property<LocalDate> getCheckInDatePicker(){
    return checkInDatePicker;
  }
  public Property<LocalDate> getCheckOutDatePicker(){
    return checkOutDatePicker;
  }
  public StringProperty getRoomNumber(){
    return roomNumber;
  }
  public StringProperty getRoomType(){
    return roomType;
  }
  public RoomList searchRooms(){
    LocalDate checkInDate = checkInDatePicker.get();
    LocalDate checkOutDate = checkOutDatePicker.get();
    String typeOfRoom = roomType.get();
    if (checkInDate.isAfter(checkOutDate)) {
      System.out.println("ERROR");
      return null;
    }
    if(reserveModel.searchAvailableRoom(checkInDate,checkOutDate,typeOfRoom).getType().equals("Available rooms")){
      return (RoomList) reserveModel.searchAvailableRoom(checkInDate,checkOutDate,typeOfRoom).getObject();
    }else{
      return null;
    }
  }
  public void Reserve(){
    Reservation reservation = new Reservation(1,Integer.parseInt(roomNumber.get()),"username",
        Date.valueOf(checkInDatePicker.get()),Date.valueOf(checkOutDatePicker.get()));
    reserveModel.reserveRoom(reservation);
  }
  public void Cancel(){
    Reservation reservation = new Reservation(1,Integer.parseInt(roomNumber.get()),"username",
        Date.valueOf(checkInDatePicker.get()),Date.valueOf(checkOutDatePicker.get()));
    reserveModel.cancelReservation(reservation);
  }
}

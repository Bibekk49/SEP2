package sem2.sep2.client.view.reserveView;

import javafx.beans.property.*;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.shared.util.room.RoomList;

import java.time.LocalDate;

public class ReserveViewModel {
  private RoomModel reserveModel;
  private StringProperty roomType;
  private ObjectProperty<LocalDate> checkInDatePicker,checkOutDatePicker;
//  private SearchModel searchModel;
  public ReserveViewModel(RoomModel reserveModel)
  {
    this.reserveModel = reserveModel;
    checkInDatePicker = new SimpleObjectProperty<>();
    checkOutDatePicker = new SimpleObjectProperty<>();
    roomType = new SimpleStringProperty();
  }
  public Property<LocalDate> getCheckInDatePicker(){
    return checkInDatePicker;
  }
  public Property<LocalDate> getCheckOutDatePicker(){
    return checkOutDatePicker;
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
}

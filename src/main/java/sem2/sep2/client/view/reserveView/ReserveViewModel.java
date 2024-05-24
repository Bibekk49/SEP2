package sem2.sep2.client.view.reserveView;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.client.view.loginView.LoginViewModel;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;
import sem2.sep2.shared.util.users.Guest;

import java.sql.Date;
import java.time.LocalDate;

public class ReserveViewModel {
    private RoomModel reserveModel;
    private StringProperty roomType,errorText;
    private ObservableList<String> roomTypes = FXCollections.observableArrayList("Single", "Double", "Suite");
    private ObjectProperty<LocalDate> checkInDatePicker, checkOutDatePicker;
    private ObservableList<Room> availableRooms = FXCollections.observableArrayList();
    private ObjectProperty<Room> selectedRoom = new SimpleObjectProperty<>();
    private LoginViewModel loginViewModel;

    public ReserveViewModel(RoomModel reserveModel) {
        this.reserveModel = reserveModel;
        checkInDatePicker = new SimpleObjectProperty<>();
        checkOutDatePicker = new SimpleObjectProperty<>();
        roomType = new SimpleStringProperty();
        errorText = new SimpleStringProperty();
    }

    public Property<LocalDate> getCheckInDatePicker() {
        return checkInDatePicker;
    }

    public Property<LocalDate> getCheckOutDatePicker() {
        return checkOutDatePicker;
    }

    public StringProperty getRoomType() {
        return roomType;
    }

    public ObservableList<String> getRoomTypes() {
        return roomTypes;
    }

    public void Reserve(String username) {
        reserveModel.reserveRoom(new Reservation(0,selectedRoom.get().getRoomNumber(),username, Date.valueOf(checkInDatePicker.get()),Date.valueOf(checkOutDatePicker.get())));
    }

    public boolean searchAvailableRooms() {
        try {
            RoomList roomList = (RoomList) reserveModel.searchAvailableRoom(checkInDatePicker.get(), checkOutDatePicker.get(), roomType.get()).getObject();
            availableRooms.addAll(roomList.getAllRooms());
            return true;
        } catch (Exception e) {
            errorText.set(e.getMessage());
            return false;
        }
    }

    public ObservableList<Room> getAvailableRooms() {
        RoomList roomList = (RoomList) reserveModel.searchAvailableRoom(checkInDatePicker.get(), checkOutDatePicker.get(), roomType.get()).getObject();
        availableRooms.addAll(roomList.getAllRooms());
        return availableRooms;
    }

    public ObservableValue<String> getErrorText() {
        return errorText;
    }
    public ObjectProperty<Room> selectedRoomProperty() {
        return selectedRoom;
    }
}

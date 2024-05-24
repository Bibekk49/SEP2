package sem2.sep2.client.view.manageRoomView;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.client.model.contact.ContactModel;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.Occupied;
import sem2.sep2.shared.util.room.roomState.Reserved;
import sem2.sep2.shared.util.room.roomState.RoomState;


public class ManageRoomViewModel {
    private RoomModel roomModel;
    private ContactModel contactModel;
    private StringProperty roomNumber, price, roomType, error;
    private StringProperty roomNumberEdit, priceEdit, roomTypeEdit, errorEdit;

    private ObservableList<String> roomTypes = FXCollections.observableArrayList("Single", "Double", "Suite");
    private ObservableList<Room> allrooms = FXCollections.observableArrayList();
    private ObservableList<Reservation> allReservations = FXCollections.observableArrayList();
    private ObjectProperty<Room> selectedRoom;

    public ManageRoomViewModel(RoomModel roomModel, ContactModel contactModel) {
        this.roomModel = roomModel;
        this.contactModel = contactModel;

        roomNumber = new SimpleStringProperty();
        price = new SimpleStringProperty();
        roomType = new SimpleStringProperty();
        error = new SimpleStringProperty();
        selectedRoom = new SimpleObjectProperty<>();

        roomNumberEdit = new SimpleStringProperty();
        priceEdit = new SimpleStringProperty();
        roomTypeEdit = new SimpleStringProperty();
        errorEdit = new SimpleStringProperty();
        reset();
    }

    public void reset() {
        roomNumber.set("");
        price.set("");
        roomType.set("Single");
        error.set("");
    }

    public void resetEdit() {
        roomNumberEdit.set(String.valueOf(selectedRoom.get().getRoomNumber()));
        priceEdit.set(String.valueOf(selectedRoom.get().getPrice()));
        roomTypeEdit.set(selectedRoom.get().getType());
        errorEdit.set("");
    }

    public StringProperty getRoomNumber() {
        return roomNumber;
    }

    public StringProperty getPrice() {
        return price;
    }

    public ObservableList<String> getRoomTypes() {
        return roomTypes;
    }

    public Room getSelectedRoom() {
        return selectedRoom.get();
    }

    public ObjectProperty<Room> selectedRoomProperty() {
        return selectedRoom;
    }


    public StringProperty getRoomNumberEdit() {
        return roomNumberEdit;
    }


    public StringProperty getPriceEdit() {
        return priceEdit;
    }

    public StringProperty getRoomTypeEdit() {
        return roomTypeEdit;
    }


    public StringProperty getErrorEdit() {
        return errorEdit;
    }

    public boolean addRoom() {
        try {
            RoomState roomState = new Available();
            Request<Room> request = roomModel.createRoom(new Room(Integer.parseInt(roomNumber.get()), roomType.get(),
                    Double.parseDouble(price.get()), roomState));
            roomNumber.set("");
            price.set("");
            roomType.set("Single");
            error.set(request.getType());
            return true;
        } catch (NumberFormatException e) {
            error.set("Some fields are empty or invalid");
        }
        return false;
    }

    public void deleteRoom() {
        try {
            if (selectedRoom.get() == null) {
                throw new RuntimeException("Please select a room");
            }
            System.out.println(selectedRoom.get());
            roomModel.deleteRoom(selectedRoom.get());
            refresh();
        } catch (Exception e) {
            error.set(e.getMessage());
        }
    }

    public boolean editRoom() {
        try {
            RoomState roomState;
            switch (selectedRoom.get().getRoomState()){
                case "Available":
                    roomState = new Available();
                    break;
                case "Occupied":
                    roomState = new Occupied();
                    break;
                default:
                    roomState=new Reserved();
            }
            this.deleteRoom();
            Request<Room> request = roomModel.createRoom(new Room(Integer.parseInt(roomNumberEdit.get()), roomTypeEdit.get(),
                    Double.parseDouble(priceEdit.get()), roomState));
            roomNumberEdit.set("");
            priceEdit.set("");
            roomTypeEdit.set("Single");
            errorEdit.set(request.getType());
            return true;
        } catch (NumberFormatException e) {
            error.set("Some fields are empty or invalid");
        }
        return false;
    }


    public ObservableList<Room> getAllrooms() {
        Request request = roomModel.getAllRooms();
        allrooms.addAll(((RoomList) request.getObject()).getAllRooms());
        return allrooms;
    }

    public StringProperty getError() {
        return error;
    }

    public void refresh() {
        allrooms.clear();
        allrooms = getAllrooms();
        allReservations.clear();
        allReservations = getAllReservations();
    }

    public Property<String> getRoomType() {
        return roomType;
    }

    public ObservableList<Reservation> getAllReservations() {
        Request request = roomModel.getallCurrentReservations();
        allReservations.addAll(((ReservationList) request.getObject()).getAllReservations());
        return allReservations;
    }
}

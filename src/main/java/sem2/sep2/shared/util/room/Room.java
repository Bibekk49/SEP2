package sem2.sep2.shared.util.room;

import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.RoomState;

public class Room {
    private String type;
    private double price;
  private RoomState roomState;
    private int roomNumber;

    public Room(int roomNumber,String type, Double price, RoomState roomState) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.roomState=roomState;
    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public int getRoomNumber(){
        return roomNumber;
    }

    public String getRoomState() {
        switch (roomState.getClass().getSimpleName()) {
            case "Available":
                return "Available";
            case "Reserved":
                return "Reserved";
            case "Occupied":
                return "Occupied";
            default:
                return "Unknown";
        }
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
    }

    public void reserve() {
        roomState.reserve(this);
    }

    public void checkIn() {
        roomState.checkIn(this);
    }

    public void checkOut() {
        roomState.checkOut(this);
    }

    public void cancelReservation() {
        roomState.cancelReservation(this);
    }
}

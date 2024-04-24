package sem2.sep2.shared.util.room;

import sem2.sep2.shared.util.room.roomState.RoomState;

public class Room {
    private String type;
    private double price;
    private RoomState roomState;

    public Room(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getBedType() {
        return type;
    }

    public void setBedType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RoomState getRoomState() {
        return roomState;
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

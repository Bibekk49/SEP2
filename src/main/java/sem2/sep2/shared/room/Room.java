package sem2.sep2.shared.room;

import sem2.sep2.shared.room.roomState.RoomState;

public class Room {
    private String bedType;
    private double price;
    private RoomState roomState;

    public Room(String bedType, int price) {
        this.bedType = bedType;
        this.price = price;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
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

package sem2.sep2.shared.util.room;

import sem2.sep2.shared.util.room.roomState.RoomState;

import java.io.Serializable;

public class Room implements Serializable
{
    private String type;
    private double price;
    private RoomState roomState;
    private int roomNumber;
    private String roomAvailability;

    public Room(int roomNumber, String type, Double price, RoomState roomState) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.roomState = roomState;
        if (roomState.getClass().getSimpleName().equals("Available")) {
            this.roomAvailability = "Available";
        } else if (roomState.getClass().getSimpleName().equals("Reserved")) {
            this.roomAvailability = "Reserved";
        } else if (roomState.getClass().getSimpleName().equals("Occupied")) {
            this.roomAvailability = "Occupied";
        } else {
            this.roomAvailability = "Unknown";
        }
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getRoomNumber() {
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

    public String getRoomAvailability() {
        return roomAvailability;
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

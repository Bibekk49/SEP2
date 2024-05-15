package sem2.sep2.shared.util;

//import sem2.sep2.shared.util.room.roomState.AvailableState;
//import sem2.sep2.shared.util.room.roomState.RoomState;

import java.io.Serializable;

public class Room implements Serializable
{
    private String type;
    private double price;
//    private RoomState roomState;
    private int room_id;
    private String status;

    public Room(int room_id,String type, Double price,String status) {
        this.room_id = room_id;
        this.type = type;
        this.price = price;
//        this.roomState=new AvailableState();
        this.status = status;
    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public int getRoom_id(){
        return room_id;
    }
    public String getStatus(){
        return status;
    }

//    public RoomState getRoomState() {
//        return roomState;
//    }
//
//    public void setRoomState(RoomState roomState) {
//        this.roomState = roomState;
//    }

//    public void reserve() {
//        roomState.reserve(this);
//    }
//
//    public void checkIn() {
//        roomState.checkIn(this);
//    }
//
//    public void checkOut() {
//        roomState.checkOut(this);
//    }
//
//    public void cancelReservation() {
//        roomState.cancelReservation(this);
//    }
    @Override
    public String toString(){
        return "Room: "+room_id+" Type: "+type+" price: "+price +" Status: "+status;
    }
}

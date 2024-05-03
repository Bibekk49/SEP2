package sem2.sep2.shared.util.room.roomState;

import sem2.sep2.shared.util.room.Room;

public class AvailableState implements RoomState{

    @Override
    public void reserve(Room room) {
        room.setRoomState(new ReservedState());
    }

    @Override
    public void checkIn(Room room) {
        room.setRoomState(new OccupiedState());
    }

    @Override
    public void checkOut(Room room) {
        //Already available
    }

    @Override
    public void cancelReservation(Room room) {
        //Already available
    }
    @Override
    public String toString(){
        return "Available";
    }
}

package sem2.sep2.shared.room.roomState;

import sem2.sep2.shared.room.Room;

public class OccupiedState implements RoomState{
    @Override
    public void reserve(Room room) {
        //Can't reserve
    }

    @Override
    public void checkIn(Room room) {
        // Can't check in

    }

    @Override
    public void checkOut(Room room) {
        room.setRoomState(new AvailableState());
    }

    @Override
    public void cancelReservation(Room room) {
        room.setRoomState(new AvailableState());
    }
}

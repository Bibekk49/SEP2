package sem2.sep2.shared.util.room.roomState;

import sem2.sep2.shared.util.room.Room;

import java.io.Serializable;

public class Occupied implements RoomState, Serializable
{

    @Override
    public void checkIn(Room room) {
        throw new IllegalStateException("Room is already occupied");
    }

    @Override
    public void reserve(Room room) {
        throw new IllegalStateException("Room is already occupied");
    }

    @Override
    public void cancelReservation(Room room) {
        throw new IllegalStateException("Room is not reserved");
    }

    @Override
    public void checkOut(Room room) {
        room.setRoomState(new Available());
    }
}

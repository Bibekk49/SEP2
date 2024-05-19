package sem2.sep2.shared.util.room.roomState;

import sem2.sep2.shared.util.room.Room;

import java.io.Serializable;

public class Reserved implements RoomState, Serializable
{
    @Override
    public void checkIn(Room room) {
        throw new IllegalStateException("Room is already reserved");
    }

    @Override
    public void reserve(Room room) {
        throw new IllegalStateException("Room is already reserved");
    }

    @Override
    public void cancelReservation(Room room) {
        room.setRoomState(new Available());
    }

    @Override
    public void checkOut(Room room) {
        throw new IllegalStateException("Room is not occupied");
    }
}

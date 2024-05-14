package sem2.sep2.shared.util.room.roomState;

import sem2.sep2.shared.util.room.Room;

public class Available implements RoomState {

    @Override
    public void checkIn(Room room) {
        room.setRoomState(new Occupied());
    }

    @Override
    public void reserve(Room room) {
        room.setRoomState(new Reserved());
    }

    @Override
    public void cancelReservation(Room room) {
        throw new IllegalStateException("Room is not reserved");
    }

    @Override
    public void checkOut(Room room) {
        throw new IllegalStateException("Room is not occupied");
    }
}

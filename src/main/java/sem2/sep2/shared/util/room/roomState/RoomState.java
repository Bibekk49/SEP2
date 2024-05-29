package sem2.sep2.shared.util.room.roomState;

import sem2.sep2.shared.util.room.Room;

public interface RoomState {
    void checkIn(Room room);

    void reserve(Room room);

    void cancelReservation(Room room);

    void checkOut(Room room);
}

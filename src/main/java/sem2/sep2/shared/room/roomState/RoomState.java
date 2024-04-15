package sem2.sep2.shared.room.roomState;

import sem2.sep2.shared.room.Room;

public interface RoomState {
    public void reserve(Room room);

    public void checkIn(Room room);

    public void checkOut(Room room);

    public void cancelReservation(Room room);
}

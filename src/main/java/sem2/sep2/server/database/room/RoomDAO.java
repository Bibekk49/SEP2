package sem2.sep2.server.database.room;

import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;

import java.sql.Date;
import java.time.LocalDate;

public interface RoomDAO {
    String  addRoom(Room room);
    void removeRoom(Room room);
    void updateRoom(Room room);
    RoomList getAllRooms();
    RoomList getAvailableRooms(Date dateFrom, Date dateTo);
    RoomList getAllRoomsByType(String category);
    RoomList getAllAvailableRoomsByType(String roomType, LocalDate dateFrom, LocalDate dateTo);

}

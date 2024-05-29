package sem2.sep2.server.database.room;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;

import java.sql.Date;
import java.time.LocalDate;

public interface RoomDAO {
    Request addRoom(Room room);
    Request removeRoom(Room room);
    Request updateRoom(Room room);
    Request getAllRooms();
    Request getAvailableRooms(Date dateFrom, Date dateTo);
    Request getAllRoomsByType(String category);
    Request getAllAvailableRoomsByType(String roomType, LocalDate dateFrom, LocalDate dateTo);

}

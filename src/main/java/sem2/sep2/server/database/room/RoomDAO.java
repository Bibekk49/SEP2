package sem2.sep2.server.database.room;

import sem2.sep2.shared.util.room.Room;

public interface RoomDAO {
    void addRoom(Room room);
    void removeRoom(int roomNumber);
    void updateRoom(Room room);
    void getRoomByNumber(int roomNumber);
    void getAllRooms();
    void getAvailableRooms();
    void getAllRoomsByType(String category);
    void getAllAvailableRoomsByType(String category, String dateFrom, String dateTo);
}

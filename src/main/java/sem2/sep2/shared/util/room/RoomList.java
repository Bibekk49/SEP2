package sem2.sep2.shared.util.room;

import java.util.ArrayList;

public class RoomList {
    private ArrayList<Room> roomList;
    public RoomList() {
        this.roomList = new ArrayList<>();
    }
    public void addRoom(Room room) {
        for (Room r : roomList) {
            if (r.getRoomNumber() == room.getRoomNumber())
                throw new IllegalArgumentException("Room already exists");
        }
        roomList.add(room);
    }
    public Room getRoomByNumber(int roomNumber) {
        for (Room r : roomList) {
            if (r.getRoomNumber() == roomNumber)
                return r;
        }
        throw new IllegalArgumentException("Room not found");
    }
    public ArrayList<Room> getAllRooms() {
        return roomList;
    }
    public void removeRoom(int roomNumber) {
        for (Room r : roomList) {
            if (r.getRoomNumber() == roomNumber) {
                roomList.remove(r);
                return;
            }
        }
        throw new IllegalArgumentException("Room not found");
    }
}

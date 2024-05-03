package sem2.sep2.shared.util;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> roomList;
    private ArrayList<Guest> guestList;

    public Hotel() {
        this.roomList = new ArrayList<>();
        this.guestList = new ArrayList<>();
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

    public void removeGuest(Guest guest) {
        guestList.remove(guest);
    }

    public ArrayList<Room> getAllRooms() {
        return roomList;
    }

    public ArrayList<Guest> getALlGuests() {
        return guestList;
    }
}

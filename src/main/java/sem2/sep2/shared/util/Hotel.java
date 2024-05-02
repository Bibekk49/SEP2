package sem2.sep2.shared.util;

import sem2.sep2.shared.util.room.Room;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> roomlist;
    private ArrayList<Guest> guestList;

    public Hotel() {
        this.roomlist = new ArrayList<>();
        this.guestList = new ArrayList<>();
    }

    public void addroom(Room room) {
        roomlist.add(room);
    }

    public void removeRoom(Room room) {
        roomlist.remove(room);
    }

    public void addGuest(Guest guest) {
        guestList.add(guest);
    }

    public void removeGuest(Guest guest) {
        guestList.remove(guest);
    }

    public ArrayList<Room> getAllrooms() {
        return roomlist;
    }

    public ArrayList<Guest> getALlGuests() {
        return guestList;
    }
}

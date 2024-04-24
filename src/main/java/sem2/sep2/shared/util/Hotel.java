package sem2.sep2.shared.util;

import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.Roomlist;

public class Hotel {
    private Roomlist roomlist;
    private GuestList guestList;

    public Hotel() {
        this.roomlist = new Roomlist();
        this.guestList = new GuestList();
    }

    public void addroom(Room room) {
        roomlist.addRoom(room);
    }

    public void removeRoom(Room room) {
        roomlist.removeRoom(room);
    }

    public void addGuest(Guest guest) {
        guestList.addGuest(guest);
    }

    public void removeGuest(Guest guest) {
        guestList.removeGuest(guest);
    }

    public Roomlist getAllrooms() {
        return roomlist;
    }

    public GuestList getALlGuests() {
        return guestList;
    }
}

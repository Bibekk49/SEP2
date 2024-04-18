package sem2.sep2.shared;

import sem2.sep2.shared.room.Roomlist;

public class Hotel {
private Roomlist roomlist;
private GuestList guestList;

    public Hotel() {
        this.roomlist = new Roomlist();
        this.guestList = new GuestList();
    }
}

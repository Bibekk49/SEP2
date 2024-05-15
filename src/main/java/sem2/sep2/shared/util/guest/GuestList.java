package sem2.sep2.shared.util.guest;

import sem2.sep2.shared.util.users.Guest;

import java.util.ArrayList;

public class GuestList {
    private ArrayList<Guest> guestList;

    public GuestList() {
        this.guestList = new ArrayList<>();
    }
    public ArrayList<Guest> getAllGuests() {
        return guestList;
    }
}
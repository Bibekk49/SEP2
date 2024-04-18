package sem2.sep2.shared;

import java.util.ArrayList;

public class GuestList {
    private ArrayList<Guest> guests;

    public GuestList() {
        this.guests = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }
}

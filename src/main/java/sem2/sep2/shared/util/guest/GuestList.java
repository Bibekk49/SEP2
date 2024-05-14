package sem2.sep2.shared.util.guest;

import java.util.ArrayList;

public class GuestList {
    private ArrayList<Guest> guestList;

    public GuestList() {
        this.guestList = new ArrayList<>();
    }

    public void addGuest(Guest guest) {
        for (Guest g : guestList) {
            if (g.getId() == guest.getId())
                throw new IllegalArgumentException("Guest already exists");
        }
    }

    public Guest getGuestByID(int id) {
        for (Guest g : guestList) {
            if (g.getId() == id)
                return g;
        }
        throw new IllegalArgumentException("Guest not found");
    }
    public ArrayList<Guest> getAllGuests() {
        return guestList;
    }
}
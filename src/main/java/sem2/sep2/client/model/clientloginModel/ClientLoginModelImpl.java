package sem2.sep2.client.model.clientloginModel;

import sem2.sep2.shared.util.guest.Guest;
import sem2.sep2.shared.util.guest.GuestList;

public class ClientLoginModelImpl implements ClientLoginModel {
    private GuestList guestList;

    public ClientLoginModelImpl() {
        this.guestList = new GuestList();
    }

    @Override
    public void login(int id, String username, String password) throws IllegalArgumentException {
        Guest guest = new Guest(id, username, password);
        guestList.getGuestByID(id);

    }

    @Override
    public void register(int id,String username, String password) {
        Guest guest = new Guest(id, username, password);
        guestList.addGuest(guest);
    }
}

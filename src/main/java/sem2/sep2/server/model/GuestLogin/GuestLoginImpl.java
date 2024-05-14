package sem2.sep2.server.model.GuestLogin;

import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.guest.GuestList;

public class GuestLoginImpl implements GuestLoginModel{
    private GuestList guestList;

    public GuestLoginImpl() {
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

    @Override
    public void setPassword(Guest guest, String password) {
        guest.setPassword(password);
    }


    @Override
    public String getPassword(Guest guest) {
        return guest.getPassword();
    }

    @Override
    public void changeUsername(Guest guest, String username) {

    }


}

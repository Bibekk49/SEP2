package sem2.sep2.shared;

import sem2.sep2.shared.room.Room;
import sem2.sep2.shared.room.Roomlist;

public class Guest {
    private String username;
    private String password;
    private Roomlist reservations;

    public Guest(String username, String password, Roomlist roomlist) {
        this.username = username;
        this.password = password;
        reservations=roomlist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addReservation(Room room) {
        reservations.addRoom(room);
    }

    public void cancelReservation(Room room) {
        reservations.removeRoom(room);
    }

    public Roomlist getAllReservations() {
        return reservations;
    }
}

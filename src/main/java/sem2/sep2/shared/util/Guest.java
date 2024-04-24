package sem2.sep2.shared.util;

import java.util.ArrayList;

public class Guest {
    private String username;
    private String password;
    private ArrayList<Reservation> reservations;

    public Guest(String username, String password) {
        this.username = username;
        this.password = password;
        reservations = new ArrayList<>();
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

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void cancelReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public ArrayList<Reservation> getAllReservations() {
        return reservations;
    }
}

package sem2.sep2.shared.util;

import java.util.ArrayList;

public class Guest {
    private String username;
    private int id;
    private String password;
    private ArrayList<Reservation> reservations;

    public Guest(int id,String username, String password) {
        this.id = id;
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
    @Override
    public String toString() {
        return "ID:"+id+"  Username: "+username;
    }
}

package sem2.sep2.shared.util.guest;

import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;

import java.util.ArrayList;

public class Guest {
    private String username;
    private int id;
    private String password;
    private final ReservationList reservations;

    public Guest(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        reservations = new ReservationList();
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addReservation(Reservation reservation) {
        reservations.addReservation(reservation);
    }


    public ArrayList<Reservation> getAllReservations() {
        return reservations.getAllReservations();
    }

    public Reservation getReservationbyID(int id) {
        return reservations.getReservationByID(id);
    }

    public void cancelReservation(int id) {
        reservations.cancelReservation(id);
    }
    void login(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}

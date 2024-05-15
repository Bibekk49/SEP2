package sem2.sep2.shared.util.users;

import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;

import java.util.ArrayList;

public class Guest extends User {
    private String username;
    private String password;
    private final ReservationList reservations;
    public Guest(String username, String password) {
        super(username, password);
        reservations = new ReservationList();
    }

    @Override
    public String getEmployeeType() {
        return UserType.GUEST.toString();
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
    void login( String username, String password) {
        this.username = username;
        this.password = password;
    }

}

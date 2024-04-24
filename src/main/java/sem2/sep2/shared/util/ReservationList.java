package sem2.sep2.shared.util;

import java.util.ArrayList;

public class ReservationList {
    private ArrayList<Reservation> reservations;

    public ReservationList() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}

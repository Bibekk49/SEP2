package sem2.sep2.shared.util.reservation;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable
{
    private ArrayList<Reservation> reservationList;

    public ReservationList() {
        this.reservationList = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        for (Reservation r : reservationList) {
            if (r.getReservationID() == reservation.getReservationID())
                throw new IllegalArgumentException("Reservation already exists");
        }
    }


    public ArrayList<Reservation> getAllReservations() {
        return reservationList;
    }

    public void cancelReservation(int id) {
        for (Reservation r : reservationList) {
            if (r.getReservationID() == id) {
                reservationList.remove(r);
                return;
            }
        }
        throw new IllegalArgumentException("Reservation not found");
    }
}

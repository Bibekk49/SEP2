package sem2.sep2.shared.util.reservation;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable {
    private ArrayList<Reservation> reservationList;

    public ReservationList() {
        this.reservationList = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {

        boolean exists = reservationList.stream()
                .anyMatch(reservation1 -> reservation1.getReservationID() == reservation.getReservationID());
        if (!exists)
            reservationList.add(reservation);


    }


    public ArrayList<Reservation> getAllReservations() {
        return reservationList;
    }
}

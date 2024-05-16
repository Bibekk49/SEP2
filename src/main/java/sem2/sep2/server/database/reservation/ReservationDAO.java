package sem2.sep2.server.database.reservation;

import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;

public interface ReservationDAO {
    String addReservation(Reservation reservation);

    void cancelReservation(Reservation reservation);

    //We will add update reservation method if we have time.
//    void updateReservation(Reservation reservation);
//    Reservation getReservation(int reservationId);
    ReservationList getCurrentReservationsByGuest(String username);

    ReservationList getAllCurrentReservations();


}
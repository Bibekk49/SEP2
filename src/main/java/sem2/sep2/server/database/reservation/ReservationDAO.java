package sem2.sep2.server.database.reservation;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;

import java.util.List;

public interface ReservationDAO {
    Request addReservation(Reservation reservation);

    Request cancelReservation(Reservation reservation);

    //We will add update reservation method if we have time.
//    void updateReservation(Reservation reservation);
//    Reservation getReservation(int reservationId);
    List<Reservation> getHistory();
    Request getCurrentReservationsByGuest(String username);

    Request<ReservationList> getAllCurrentReservations();
    boolean checkRoomAvailability(Reservation newReservation);
}

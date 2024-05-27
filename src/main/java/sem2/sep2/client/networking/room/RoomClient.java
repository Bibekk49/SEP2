package sem2.sep2.client.networking.room;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;

import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface RoomClient
{
    Request<RoomList> searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo, String roomType);

    Request getAllRooms();

    Request createRoom(Room room);

    Request updateRoom(Room room);

    Request deleteRoom(Room room);
    Request reserveRoom(Reservation reservation);
    Request cancelReservation(Reservation reservation);
    Request getCurrentReservationsByGuest(String username);
    Request<ReservationList> getallCurrentReservations();
    List<Reservation> getHistory();
}

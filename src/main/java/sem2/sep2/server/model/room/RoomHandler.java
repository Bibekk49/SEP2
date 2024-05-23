package sem2.sep2.server.model.room;

import sem2.sep2.shared.Observer;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.time.LocalDate;

public interface RoomHandler extends Observer
{
    Request searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo,String roomType);
    Request getAllRooms();
    Request createRoom(Room room);
    Request updateRoom(Room room);
    Request deleteRoom(Room room);
    Request reserveRoom(Reservation reservation);
    Request cancelReservation(Reservation reservation);
    Request getCurrentReservationsByGuest(String username);
    Request getallCurrentReservations();


}

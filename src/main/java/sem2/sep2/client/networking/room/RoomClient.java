package sem2.sep2.client.networking.room;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.rmi.RemoteException;
import java.sql.Date;

public interface RoomClient
{
    Request searchAvailableRoom(Date dateFrom, Date dateTo, String roomType);

    Request getAllRooms();

    Request createRoom(Room room);

    Request updateRoom(Room room);

    Request deleteRoom(Room room);
    Request reserveRoom(Reservation reservation);
    Request cancelReservation(Reservation reservation);
    Request getCurrentReservationsByGuest(String username);
    Request getallCurrentReservations();
}
package sem2.sep2.server.model.room;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.List;

public interface RoomHandler
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
    List<Reservation> getHistory();
    Request changeRoomState(int roomNumber, String state);
    

}

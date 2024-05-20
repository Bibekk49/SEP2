package sem2.sep2.client.model.Room;

import sem2.sep2.client.networking.room.RoomClient;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.sql.Date;
import java.time.LocalDate;

public class RoomModelImpl implements RoomModel
{
  private RoomClient roomClient;
  public RoomModelImpl(RoomClient roomClient){
    this.roomClient = roomClient;
  }

  @Override
  public Request searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo,String roomType) {
    return roomClient.searchAvailableRoom(dateFrom, dateTo,roomType);
  }

  @Override
  public Request getAllRooms() {
    return roomClient.getAllRooms();
  }

  @Override
  public Request createRoom(Room room) {
    return roomClient.createRoom(room);
  }

  @Override
  public Request updateRoom(Room room) {
    return roomClient.updateRoom(room);
  }

  @Override
  public Request deleteRoom(Room room) {
    return roomClient.deleteRoom(room);
  }

  @Override
  public Request reserveRoom(Reservation reservation) {
    return roomClient.reserveRoom(reservation);
  }

  @Override
  public Request cancelReservation(Reservation reservation) {
    return roomClient.cancelReservation(reservation);
  }

  @Override
  public Request getCurrentReservationsByGuest(String username) {
    return roomClient.getCurrentReservationsByGuest(username);
  }

  @Override
  public Request getallCurrentReservations() {
    return roomClient.getallCurrentReservations();
  }
}

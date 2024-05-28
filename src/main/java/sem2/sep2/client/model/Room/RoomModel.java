package sem2.sep2.client.model.Room;

import sem2.sep2.shared.Subject;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;

import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface RoomModel extends Subject {
  Request searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo,String roomType);
  Request getAllRooms();
  Request createRoom(Room room);
  Request updateRoom(Room room);
  Request deleteRoom(Room room);
  Request reserveRoom(Reservation reservation);
  Request cancelReservation(Reservation reservation);
  Request getCurrentReservationsByGuest(String username);
  Request<ReservationList> getallCurrentReservations();

//  List<Reservation> getHistory();
  void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
  void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

}

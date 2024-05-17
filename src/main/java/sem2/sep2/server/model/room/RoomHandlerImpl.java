package sem2.sep2.server.model.room;

import sem2.sep2.server.database.reservation.ReservationDAO;
import sem2.sep2.server.database.reservation.ReservationDAOImpl;
import sem2.sep2.server.database.room.RoomDAO;
import sem2.sep2.server.database.room.RoomDAOImpl;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;

public class RoomHandlerImpl implements RoomHandler {
    private RoomDAO roomDAO;
    private ReservationDAO reservationDAO;
    private PropertyChangeSupport support;

    public RoomHandlerImpl() {
        roomDAO = new RoomDAOImpl();
        reservationDAO = new ReservationDAOImpl();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public Request searchAvailableRoom(Date dateFrom, Date dateTo, String roomType) {
        try{
        RoomList allAvailableRoomsByType = roomDAO.getAllAvailableRoomsByType(roomType, dateFrom, dateTo);
        support.firePropertyChange("Available rooms", null, allAvailableRoomsByType);
        return new Request("Available rooms", allAvailableRoomsByType);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request getAllRooms() {
        try {
            RoomList roomList = roomDAO.getAllRooms();
            return new Request("All rooms", roomList);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request createRoom(Room room) {
        try {
            roomDAO.addRoom(room);
            return new Request("Room created", null);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request updateRoom(Room room) {
        try {
            roomDAO.updateRoom(room);
            return new Request("Room updated", null);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request deleteRoom(Room room) {
        try {
            roomDAO.removeRoom(room);
            return new Request("Room deleted", null);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request reserveRoom(Reservation reservation) {
        try {
            reservationDAO.addReservation(reservation);
            return new Request("Room reserved", null);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request cancelReservation(Reservation reservation) {
        try {
            reservationDAO.cancelReservation(reservation);
            return new Request("Reservation cancelled", null);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request getCurrentReservationsByGuest(String username) {
        try {
            ReservationList currentReservationsByGuest = reservationDAO.getCurrentReservationsByGuest(username);
            return new Request("Current reservations", currentReservationsByGuest);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request getallCurrentReservations() {
        try {
            ReservationList allCurrentReservations = reservationDAO.getAllCurrentReservations();
            return new Request("All current reservations", allCurrentReservations);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}

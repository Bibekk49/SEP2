package sem2.sep2.server.model.room;

import sem2.sep2.server.database.reservation.ReservationDAO;
import sem2.sep2.server.database.reservation.ReservationDAOImpl;
import sem2.sep2.server.database.room.RoomDAO;
import sem2.sep2.server.database.room.RoomDAOImpl;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.List;

public class RoomHandlerImpl implements RoomHandler {
    private RoomDAO roomDAO;
    private ReservationDAO reservationDAO;

    public RoomHandlerImpl() {
        roomDAO = new RoomDAOImpl();
        reservationDAO = new ReservationDAOImpl();
    }

    @Override
    public Request searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo, String roomType) {
        Request request = roomDAO.getAllAvailableRoomsByType(roomType, dateFrom, dateTo);
        return request;
    }

    @Override
    public Request getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    public Request createRoom(Room room) {
        return roomDAO.addRoom(room);
    }

    @Override
    public Request updateRoom(Room room) {
        return roomDAO.updateRoom(room);
    }

    @Override
    public Request deleteRoom(Room room) {
        return roomDAO.removeRoom(room);
    }

    @Override
    public Request reserveRoom(Reservation reservation) {
        return reservationDAO.addReservation(reservation);
    }

    @Override
    public Request cancelReservation(Reservation reservation) {
        return reservationDAO.cancelReservation(reservation);
    }

    @Override
    public Request getCurrentReservationsByGuest(String username) {
        return reservationDAO.getCurrentReservationsByGuest(username);
    }

    @Override
    public Request getallCurrentReservations() {
        return reservationDAO.getAllCurrentReservations();
    }

    @Override
    public List<Reservation> getHistory(){
        return reservationDAO.getHistory();
    }

}

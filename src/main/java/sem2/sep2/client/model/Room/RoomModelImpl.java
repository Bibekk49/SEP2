package sem2.sep2.client.model.Room;

import sem2.sep2.client.networking.room.RoomClient;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.List;

public class RoomModelImpl implements RoomModel {
    private RoomClient roomClient;
    private PropertyChangeSupport support;

    public RoomModelImpl(RoomClient roomClient) {
        this.roomClient = roomClient;
        support = new PropertyChangeSupport(this);
    }

    @Override
    public Request searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo, String roomType) {
        return roomClient.searchAvailableRoom(dateFrom, dateTo, roomType);
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
    public Request<ReservationList> getallCurrentReservations() {
        return roomClient.getallCurrentReservations();
    }

    public List<Reservation> getHistory() {
        return roomClient.getHistory();
    }

//  public void updateHistory(List<Reservation> newHistory) {
//    support.firePropertyChange("ReservationHistoryUpdated", null, newHistory);
//  }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(propertyName, listener);
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

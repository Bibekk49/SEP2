package sem2.sep2.server.networking.room;

import sem2.sep2.server.model.room.RoomHandler;
import sem2.sep2.shared.networking.serverInterfaces.RoomServer;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

public class RoomServerImpl implements RoomServer {
    private RoomHandler roomHandler;

    public RoomServerImpl(RoomHandler roomHandler) throws RemoteException {
        this.roomHandler = roomHandler;
        UnicastRemoteObject.exportObject(this, 0);
        roomHandler.addListener("Available Rooms", this::fireAvailableRooms);
    }

    private void fireAvailableRooms(PropertyChangeEvent propertyChangeEvent) {
    }

    @Override
    public Request searchAvailableRoom(Date dateFrom, Date dateTo, String roomType) throws RemoteException {
        return roomHandler.searchAvailableRoom(dateFrom, dateTo, roomType);
    }

    @Override
    public Request getAllRooms() throws RemoteException {
        return roomHandler.getAllRooms();
    }

    @Override
    public Request createRoom(Room room) throws RemoteException {
        return roomHandler.createRoom(room);
    }

    @Override
    public Request updateRoom(Room room) throws RemoteException {
        return roomHandler.updateRoom(room);
    }

    @Override
    public Request deleteRoom(Room room) throws RemoteException {
        return roomHandler.deleteRoom(room);
    }

    @Override
    public Request reserveRoom(Reservation reservation) throws RemoteException{
        return roomHandler.reserveRoom(reservation);
    }

    @Override
    public Request cancelReservation(Reservation reservation) throws RemoteException{
        return roomHandler.cancelReservation(reservation);
    }

    @Override
    public Request getCurrentReservationsByGuest(String username) throws RemoteException{
        return roomHandler.getCurrentReservationsByGuest(username);
    }

    @Override
    public Request getallCurrentReservations() throws RemoteException{
        return roomHandler.getallCurrentReservations();
    }
}

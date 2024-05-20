package sem2.sep2.shared.networking.serverInterfaces;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.time.LocalDate;

public interface RoomServer extends Remote {
    Request searchAvailableRoom(LocalDate dateFrom, LocalDate dateTo,String roomType) throws RemoteException;

    Request getAllRooms() throws RemoteException;

    Request createRoom(Room room) throws RemoteException;

    Request updateRoom(Room room) throws RemoteException;

    Request deleteRoom(Room room) throws RemoteException;
    Request reserveRoom(Reservation reservation) throws RemoteException;
    Request cancelReservation(Reservation reservation) throws RemoteException;
    Request getCurrentReservationsByGuest(String username) throws RemoteException;
    Request getallCurrentReservations() throws RemoteException;
}

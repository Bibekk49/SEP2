package sem2.sep2.client.networking.room;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.rmi.RemoteException;
import java.sql.Date;

public class RoomClientImpl implements RoomClient {
    private Server server;

    public RoomClientImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Request searchAvailableRoom(Date dateFrom, Date dateTo, String roomType) {
        try {
            return server.getRoomServer().searchAvailableRoom(dateFrom, dateTo, roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request getAllRooms() {
        try {
            return server.getRoomServer().getAllRooms();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request createRoom(Room room) {
        try {
            return server.getRoomServer().createRoom(room);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request updateRoom(Room room) {
        try {
            return server.getRoomServer().updateRoom(room);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request deleteRoom(Room room) {
        try {
            return server.getRoomServer().deleteRoom(room);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request reserveRoom(Reservation reservation) {
        try {
            return server.getRoomServer().reserveRoom(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request cancelReservation(Reservation reservation) {
        try {
            return server.getRoomServer().cancelReservation(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request getCurrentReservationsByGuest(String username) {
        try {
            return server.getRoomServer().getCurrentReservationsByGuest(username);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request getallCurrentReservations() {
        try {
            return server.getRoomServer().getallCurrentReservations();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }
}

package sem2.sep2.shared.util;

import sem2.sep2.shared.util.room.Room;

import java.util.Date;

public class Reservation {
    private int reservationID;
    private Date startDate;
    private Date endDate;
    private Room room;

    public Reservation(int reservationID, Room room, Date startDate, Date endDate) {
        this.reservationID = reservationID;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
package sem2.sep2.shared.util.reservation;

import java.sql.Date;

public class Reservation {
    private int reservationID;
    private Date startDate;

    private Date endDate;
    private int roomNumber;
    private String guestUsername;

    public Reservation(int reservationID, int roomNumber, String guestUsername, Date startDate, Date endDate) {
        this.reservationID = reservationID;
        this.roomNumber = roomNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestUsername = guestUsername;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getGuestUsername() {
        return guestUsername;
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
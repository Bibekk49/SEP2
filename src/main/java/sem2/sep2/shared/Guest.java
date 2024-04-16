package sem2.sep2.shared;

public class Guest {
    private String username;
    private String password;
    private ReservationList reservations;

    public Guest(String username, String password) {
        this.username = username;
        this.password = password;
        reservations = new ReservationList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addReservation(Reservation reservation) {
        reservations.addReservation(reservation);
    }

    public void cancelReservation(Reservation reservation) {
        reservations.removeReservation(reservation);
    }

    public ReservationList getAllReservations() {
        return reservations;
    }
}

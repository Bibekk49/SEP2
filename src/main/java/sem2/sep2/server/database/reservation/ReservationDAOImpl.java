package sem2.sep2.server.database.reservation;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;

import java.sql.*;
import java.time.LocalDate;

public class ReservationDAOImpl implements ReservationDAO {
    public ReservationDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String addReservation(Reservation reservation) {
        if (!checkRoomAvailability(reservation)) {
            return "Room is not available for the selected date range.";
        }
        String query = "INSERT INTO SEP2.reservations(room_number, username, start_date, end_date) VALUES (?, ?, ?, ?);";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, reservation.getRoomNumber());
            statement.setString(2, reservation.getGuestUsername());
            statement.setDate(3, reservation.getStartDate());
            statement.setDate(4, reservation.getEndDate());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return "Reservation created successfully";
            } else {
                return "Failed to create reservation";
            }
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
    }


    @Override
    public void cancelReservation(Reservation reservation) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM SEP2.reservations WHERE reservation_id=?;");
            statement.setInt(1, reservation.getReservationID());
            statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public ReservationList getCurrentReservationsByGuest(String username) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.reservations WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            ReservationList reservationList = new ReservationList();
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getInt("room_number"),
                        resultSet.getString("username"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                );
                reservationList.addReservation(reservation);
            }
            return reservationList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public ReservationList getAllCurrentReservations() {
        String query = "SELECT * FROM SEP2.reservations WHERE ? BETWEEN start_date AND end_date;";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            LocalDate currentDate = LocalDate.now();
            statement.setDate(1, Date.valueOf(currentDate));

            ResultSet resultSet = statement.executeQuery();
            ReservationList reservationList = new ReservationList();

            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getInt("room_number"),
                        resultSet.getString("username"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                );
                reservationList.addReservation(reservation);
            }
            return reservationList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public boolean checkRoomAvailability(Reservation newReservation) {
        String query = "SELECT COUNT(*) FROM SEP2.reservations WHERE room_number = ? AND start_date <= ? AND end_date >= ?;";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, newReservation.getRoomNumber());
            statement.setDate(2, newReservation.getEndDate());
            statement.setDate(3, newReservation.getStartDate());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count == 0; // Room is available if count is 0 (no overlapping reservations)
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

}

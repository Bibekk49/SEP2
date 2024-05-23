package sem2.sep2.server.database.reservation;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    public ReservationDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Request addReservation(Reservation reservation) {
        if (!checkRoomAvailability(reservation)) {
            return new Request("Room is not available for the selected date range.", null);
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
                return new Request("Reservation created successfully", reservation);
            } else {
                return new Request("Failed to create reservation", null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Database error", null);
        }
    }


    @Override
    public Request cancelReservation(Reservation reservation) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM SEP2.reservations WHERE reservation_id=?;");
            statement.setInt(1, reservation.getReservationID());
            statement.executeQuery();
            return new Request("Reservation cancelled successfully", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to cancel reservation", null);
        }
    }


    @Override
    public Request getCurrentReservationsByGuest(String username) {
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
            return new Request("Current reservations", reservationList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to get current reservations", null);
        }
    }

    @Override
        public Request getAllCurrentReservations() {
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
            return new Request("All current reservations", reservationList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to get all current reservations", null);
        }

    }
    @Override
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
    @Override
    public List<Reservation> getHistory(){
        return null;
    }


}

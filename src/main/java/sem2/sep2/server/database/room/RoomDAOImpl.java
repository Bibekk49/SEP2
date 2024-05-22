package sem2.sep2.server.database.room;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.Occupied;
import sem2.sep2.shared.util.room.roomState.Reserved;
import sem2.sep2.shared.util.room.roomState.RoomState;

import java.sql.*;
import java.time.LocalDate;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public Request addRoom(Room room) {
        String query = "INSERT INTO SEP2.rooms(room_number, room_type, rate, room_state) VALUES (?, ?, ?, ?);";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, room.getRoomNumber());
            statement.setString(2, room.getType());
            statement.setDouble(3, room.getPrice());
            statement.setString(4, room.getRoomState());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return new Request("Room added successfully", room);
            } else {
                return new Request("Failed to add room", null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Database error", null);
        }
    }

    @Override
    public Request removeRoom(Room room) {
        String query = "DELETE FROM SEP2.rooms WHERE room_number=?;";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, room.getRoomNumber());

            statement.executeUpdate();
            return new Request("Room removed successfully", null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to remove room", null);
        }
    }

    @Override
    public Request updateRoom(Room room) {
        String query = "UPDATE SEP2.rooms SET room_type=?, rate=?, room_state=? WHERE room_number=?;";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, room.getType());
            statement.setDouble(2, room.getPrice());
            statement.setString(3, room.getRoomState());
            statement.setInt(4, room.getRoomNumber());

            statement.executeUpdate();
            return new Request("Room updated successfully", room);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to update room", null);
        }
    }


    @Override
    public Request getAllRooms() {
        String query = "SELECT * FROM SEP2.rooms;";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            RoomList roomList = new RoomList();
            while (resultSet.next()) {
                RoomState roomState;
                switch (resultSet.getString("room_state")) {
                    case "Available":
                        roomState = new Available();
                        break;
                    case "Reserved":
                        roomState = new Reserved();
                        break;
                    case "Occupied":
                        roomState = new Occupied();
                        break;
                    default:
                        return new Request("Unknown room state", null);
                }
                Room room = new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("room_type"),
                        resultSet.getDouble("rate"),
                        roomState
                );
                roomList.addRoom(room);
            }
            return new Request("Rooms fetched successfully", roomList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to get rooms", null);
        }
    }


    @Override
    public Request getAvailableRooms(Date dateFrom, Date dateTo) {
        String query = "SELECT * FROM SEP2.rooms WHERE room_number NOT IN (SELECT room_number FROM SEP2.reservations WHERE start_date <= ? AND end_date >= ?);";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, dateFrom);
            statement.setDate(2, dateTo);

            ResultSet resultSet = statement.executeQuery();
            RoomList roomList = new RoomList();

            while (resultSet.next()) {
                if ("Available".equals(resultSet.getString("room_state"))) {
                    Room room = new Room(
                            resultSet.getInt("room_number"),
                            resultSet.getString("room_type"),
                            resultSet.getDouble("rate"),
                            new Available()
                    );
                    roomList.addRoom(room);
                }
            }
            return new Request("Available rooms fetched successfully", roomList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to get available rooms", null);
        }
    }


    @Override
    public Request getAllRoomsByType(String category) {
        String query = "SELECT * FROM SEP2.rooms WHERE room_type=?;";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, category);

            ResultSet resultSet = statement.executeQuery();
            RoomList roomList = new RoomList();

            while (resultSet.next()) {
                RoomState roomState;
                switch (resultSet.getString("room_state")) {
                    case "Available":
                        roomState = new Available();
                        break;
                    case "Reserved":
                        roomState = new Reserved();
                        break;
                    case "Occupied":
                        roomState = new Occupied();
                        break;
                    default:
                        return new Request("Unknown room state", null);
                }
                Room room = new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("room_type"),
                        resultSet.getDouble("rate"),
                        roomState
                );
                roomList.addRoom(room);
            }
            return new Request("Rooms fetched successfully", roomList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to get rooms by type", null);
        }
    }

    @Override
    public Request getAllAvailableRoomsByType(String roomType, LocalDate dateFrom, LocalDate dateTo) {
        String query = "SELECT * FROM SEP2.rooms WHERE room_type=? AND room_number NOT IN (SELECT room_number FROM SEP2.reservations WHERE start_date <= ? AND end_date >= ?);";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, roomType);
            statement.setDate(2, Date.valueOf(dateFrom));
            statement.setDate(3, Date.valueOf(dateTo));

            ResultSet resultSet = statement.executeQuery();
            RoomList roomList = new RoomList();

            while (resultSet.next()) {
                if ("Available".equals(resultSet.getString("room_state"))) {
                    Room room = new Room(
                            resultSet.getInt("room_number"),
                            resultSet.getString("room_type"),
                            resultSet.getDouble("rate"),
                            new Available()
                    );
                    roomList.addRoom(room);
                }
            }
            return new Request("Available rooms fetched successfully", roomList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Request("Failed to get available rooms by type", null);
        }
    }
}

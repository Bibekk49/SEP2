package sem2.sep2.server.database.room;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.Occupied;
import sem2.sep2.shared.util.room.roomState.Reserved;
import sem2.sep2.shared.util.room.roomState.RoomState;

import java.sql.*;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public String addRoom(Room room) {
        String query = "INSERT INTO SEP2.rooms(room_number, room_type, rate, room_state) VALUES (?, ?, ?, ?);";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, room.getRoomNumber());
            statement.setString(2, room.getType());
            statement.setDouble(3, room.getPrice());
            statement.setString(4, room.getRoomState());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return "Room added successfully";
            } else {
                return "Failed to add room";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "Database error: " + throwables.getMessage();
        }
    }

    @Override
    public void removeRoom(Room room) {
        String query = "DELETE FROM SEP2.rooms WHERE room_number=?;";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, room.getRoomNumber());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room) {
        String query = "UPDATE SEP2.rooms SET room_type=?, rate=?, room_state=? WHERE room_number=?;";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, room.getType());
            statement.setDouble(2, room.getPrice());
            statement.setString(3, room.getRoomState());
            statement.setInt(4, room.getRoomNumber());

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public RoomList getAllRooms() {
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
                        throw new IllegalArgumentException("Unknown room state: " + resultSet.getString("room_state"));
                }
                Room room = new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("room_type"),
                        resultSet.getDouble("rate"),
                        roomState
                );
                roomList.addRoom(room);
            }
            return roomList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Failed to get rooms", throwables);
        }
    }


    @Override
    public RoomList getAvailableRooms(Date dateFrom, Date dateTo) {
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
            return roomList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Failed to get available rooms", throwables);
        }
    }


    @Override
    public RoomList getAllRoomsByType(String category) {
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
                        throw new IllegalArgumentException("Unknown room state: " + resultSet.getString("room_state"));
                }
                Room room = new Room(
                        resultSet.getInt("room_number"),
                        resultSet.getString("room_type"),
                        resultSet.getDouble("rate"),
                        roomState
                );
                roomList.addRoom(room);
            }
            return roomList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Failed to get rooms by type", throwables);
        }
    }

    @Override
    public RoomList getAllAvailableRoomsByType(String roomType, Date dateFrom, Date dateTo) {
        String query = "SELECT * FROM SEP2.rooms WHERE room_type=? AND room_number NOT IN (SELECT room_number FROM SEP2.reservations WHERE start_date <= ? AND end_date >= ?);";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, roomType);
            statement.setDate(2, dateFrom);
            statement.setDate(3, dateTo);

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
            return roomList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Failed to get available rooms by type", throwables);
        }
    }
}

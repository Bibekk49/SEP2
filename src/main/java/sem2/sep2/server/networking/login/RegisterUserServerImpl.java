package sem2.sep2.server.networking.login;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.networking.serverInterfaces.RegisterUserServer;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterUserServerImpl implements RegisterUserServer{
    @Override
    public String addUser(int userid,String username, String password, String userType) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SEP2.users WHERE username=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "Username is already taken";
            } else {
                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO SEP2.users(username, password, user_type) VALUES (?, ?, ?);");
                statement2.setString(1, username);
                statement2.setString(2, password);
                statement2.setString(3, userType);
                statement2.executeUpdate();
                return "User created successfully";
            }
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
    }

}

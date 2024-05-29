package sem2.sep2.server.database.contactManager;

import sem2.sep2.server.database.DataBaseConnection;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactManagerImpl implements ContactManagerDao{
    @Override
    public String contactManager(Guest guestSender, String messageBody){
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SEP2.messages (sender_username, message_body) VALUES (?, ?)");
            preparedStatement.setString(1, guestSender.getUsername());
            preparedStatement.setString(2, messageBody);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return "Message sent to manager";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Message not sent to manager";
        }
    }

    @Override
    public String managerResponse(Guest guestSender, String messageBody){
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SEP2.messages (sender_username, message_body) VALUES (?, ?)");
            preparedStatement.setString(1, "Manager");
            preparedStatement.setString(2, messageBody);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return "Message sent to guest";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Message not sent to guest";
        }
    }
}

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
        return null;
        //TODO: Implement this method
    }

    @Override
    public String managerResponse(Guest guestSender, String messageBody){
        return null;
        //TODO: Implement this method
    }
//    @Override
//    public String contactHistory(){
//
//    }
}

package sem2.sep2.server.database.contactManager;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;

import java.sql.SQLException;

public interface ContactManagerDao {
    String contactManager(Guest guestSender, String messageBody);
    String  managerResponse(Guest guestSender, String messageBody);
//    String contactHistory();
}

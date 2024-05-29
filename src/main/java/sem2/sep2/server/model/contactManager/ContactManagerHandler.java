package sem2.sep2.server.model.contactManager;

import sem2.sep2.shared.util.users.Guest;

public interface ContactManagerHandler{
  String contactManager(Guest guestSender, String messageBody);
  String  managerResponse(Guest guestSender, String messageBody);
}

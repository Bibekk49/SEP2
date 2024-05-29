package sem2.sep2.client.networking.contact;

import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;

import java.rmi.RemoteException;

public interface ContactClient
{
  String contactManager(Guest guestSender, String messageBody);
  String  managerResponse(Guest guestSender, String messageBody);
}

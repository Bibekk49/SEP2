package sem2.sep2.shared.networking.serverInterfaces;

import sem2.sep2.shared.util.users.Guest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContactManagerServer extends Remote
{
  String contactManager(Guest guestSender, String messageBody)throws RemoteException;
  String  managerResponse(Guest guestSender, String messageBody)throws RemoteException;
}

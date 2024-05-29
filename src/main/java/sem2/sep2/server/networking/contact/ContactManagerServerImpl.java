package sem2.sep2.server.networking.contact;

import sem2.sep2.server.model.contactManager.ContactManagerHandler;
import sem2.sep2.shared.networking.serverInterfaces.ContactManagerServer;
import sem2.sep2.shared.util.users.Guest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContactManagerServerImpl implements ContactManagerServer
{
  private ContactManagerHandler contactManagerHandler;
  public ContactManagerServerImpl(ContactManagerHandler contactManagerHandler)throws
      RemoteException
  {
    this.contactManagerHandler =contactManagerHandler;
    UnicastRemoteObject.exportObject(this, 0);
  }
  @Override
  public String contactManager(Guest guestSender, String messageBody)throws RemoteException{
    return contactManagerHandler.contactManager(guestSender,messageBody);
  }
  @Override
  public String  managerResponse(Guest guestSender, String messageBody)throws RemoteException{
    return contactManagerHandler.managerResponse(guestSender,messageBody);
  }
}

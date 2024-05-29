package sem2.sep2.client.networking.contact;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.users.Guest;

import java.rmi.RemoteException;

public class ContactClientImpl implements ContactClient
{
  private Server server;
  public ContactClientImpl(){
    try {
      server = GetServer.getServerFromRmi();
    } catch (Exception e) {
      throw e;
    }
  }
  @Override
  public String contactManager(Guest guestSender, String messageBody){
    try
    {
      return server.getContactManagerServer().contactManager(guestSender,messageBody);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }
  @Override
  public String  managerResponse(Guest guestSender, String messageBody){
    try{
      return server.getContactManagerServer().managerResponse(guestSender,messageBody);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException(e);
    }
  }
}
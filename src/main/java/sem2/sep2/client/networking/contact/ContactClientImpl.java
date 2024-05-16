package sem2.sep2.client.networking.contact;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;

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
  public void sendMessage(String message){
    //
  }
}

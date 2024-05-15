package sem2.sep2.client.networking.reserve;

import sem2.sep2.client.networking.GetServer;
import sem2.sep2.shared.networking.serverInterfaces.Server;

public class ReserveClientImpl implements ReserveClient
{
  private Server server;
  public ReserveClientImpl() {
    try {
      server = GetServer.getServerFromRmi();
    } catch (Exception e) {
      throw e;
    }
  }
}

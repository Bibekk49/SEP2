package sem2.sep2.client.model.reserve;

import sem2.sep2.client.networking.reserve.ReserveClient;

public class ReserveModelImpl implements ReserveModel
{
  private ReserveClient reserveClient;
  public ReserveModelImpl(ReserveClient reserveClient){
    this.reserveClient = reserveClient;
  }
  @Override
  public void reserve(int roomNumber){
    //reserve
  }
}

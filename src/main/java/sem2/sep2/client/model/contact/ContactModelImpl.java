package sem2.sep2.client.model.contact;

import sem2.sep2.client.networking.reserve.ReserveClient;

public class ContactModelImpl implements ContactModel
{
  private ReserveClient reserveClient;
  public ContactModelImpl(ReserveClient reserveClient){
    this.reserveClient = reserveClient;
  }
}

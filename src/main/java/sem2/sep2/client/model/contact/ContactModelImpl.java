package sem2.sep2.client.model.contact;

import sem2.sep2.client.networking.contact.ContactClient;
import sem2.sep2.shared.util.users.Guest;

public class ContactModelImpl implements ContactModel
{
  private ContactClient contactClient;
  public ContactModelImpl(ContactClient contactClient){
    this.contactClient = contactClient;
  }
  @Override
  public String contactManager(Guest guest,String message){
    return contactClient.contactManager(guest,message);
  }
  @Override
  public String managerResponse(Guest guest,String message){
    return contactClient.managerResponse(guest,message);
  }
}

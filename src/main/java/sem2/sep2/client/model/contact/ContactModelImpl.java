package sem2.sep2.client.model.contact;

import sem2.sep2.client.networking.contact.ContactClient;

public class ContactModelImpl implements ContactModel
{
  private ContactClient contactClient;
  public ContactModelImpl(ContactClient contactClient){
    this.contactClient = contactClient;
  }
  @Override
  public void sendMessage(String message){
//    contactClient.sendMessage(message);
  }
  @Override
  public String receiveMessage(){
    return "";
  }
}

package sem2.sep2.client.model.contact;

import sem2.sep2.shared.util.users.Guest;

public interface ContactModel
{
  String contactManager(Guest guest,String message);
  String managerResponse(Guest guest,String message);
}

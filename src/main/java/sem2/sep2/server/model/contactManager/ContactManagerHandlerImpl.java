package sem2.sep2.server.model.contactManager;

import sem2.sep2.server.database.contactManager.ContactManagerDao;
import sem2.sep2.server.database.contactManager.ContactManagerImpl;
import sem2.sep2.shared.util.users.Guest;

public class ContactManagerHandlerImpl implements ContactManagerHandler{
  private ContactManagerDao contactManagerDao;
  public ContactManagerHandlerImpl(){
    contactManagerDao = new ContactManagerImpl();
  }
  @Override
  public String contactManager(Guest guestSender, String messageBody){
    return contactManagerDao.contactManager(guestSender,messageBody);
  }
  @Override
  public String  managerResponse(Guest guestSender, String messageBody){
    return contactManagerDao.managerResponse(guestSender,messageBody);
  }
}

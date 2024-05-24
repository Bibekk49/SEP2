package sem2.sep2.server.model.contactManager;

import sem2.sep2.server.database.contactManager.ContactManagerDao;
import sem2.sep2.server.database.contactManager.ContactManagerImpl;
import sem2.sep2.shared.Subject;
import sem2.sep2.shared.util.users.Guest;

import java.util.ArrayList;
import java.util.List;

public class ContactManagerHandlerImpl implements ContactManagerHandler{
  private ContactManagerDao contactManagerDao;
  private List<Subject> observers;
  public ContactManagerHandlerImpl(){
    contactManagerDao = new ContactManagerImpl();
    observers = new ArrayList<>();
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

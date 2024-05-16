package sem2.sep2.client.view.contactView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.contact.ContactModel;

public class ContactViewModel
{
  private ContactModel contactModel;
  private StringProperty showField;
  private StringProperty chatField;

  public ContactViewModel(ContactModel contactModel)
  {
    this.contactModel = contactModel;
    showField = new SimpleStringProperty();
    chatField = new SimpleStringProperty();
  }
  public void reset() {
    showField.set(null);
    chatField.set(null);
  }
  public StringProperty getShowField(){
    return showField;
  }
  public StringProperty getChatField(){
    return chatField;
  }
  public void sendMessage() {
    try {
      contactModel.sendMessage(chatField.get());
      chatField.set("");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

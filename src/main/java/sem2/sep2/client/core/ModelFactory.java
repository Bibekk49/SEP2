package sem2.sep2.client.core;

import sem2.sep2.client.model.contact.ContactModel;
import sem2.sep2.client.model.contact.ContactModelImpl;
import sem2.sep2.client.model.login.LoginModel;
import sem2.sep2.client.model.login.LoginModelImpl;
import sem2.sep2.client.model.register.RegisterModelImpl;
import sem2.sep2.client.model.register.RegisterModel;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.client.model.Room.RoomModelImpl;

public class ModelFactory {
    private ClientFactory clientFactory;
    private LoginModel loginModel;
    private RegisterModel createModel;
    private ContactModel contactModel;
    private RoomModel reserveModel;
    private RoomModel roomModel;
    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(clientFactory.getLoginClient());
        }
        return loginModel;
    }

    public RegisterModel getCreateModel() {
        if (createModel == null) {
            createModel = new RegisterModelImpl(clientFactory.getCreateClient());
        }
        return createModel;
    }

    public RoomModel getReserveModel() {
        if (reserveModel == null) {
            reserveModel = new RoomModelImpl(clientFactory.getRoomClient());
        }
        return reserveModel;
    }

  public ContactModel getContactModel()
  {
      if(contactModel == null){
          contactModel = new ContactModelImpl(clientFactory.getContactClient());
      }
      return contactModel;
  }
  public RoomModel getRoomModel(){
      if(roomModel == null){
          roomModel = new RoomModelImpl(clientFactory.getRoomClient());
      }
      return roomModel;
  }
}

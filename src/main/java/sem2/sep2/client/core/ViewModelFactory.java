package sem2.sep2.client.core;

import sem2.sep2.client.view.contactView.ContactViewModel;
import sem2.sep2.client.view.loginView.LoginViewModel;
import sem2.sep2.client.view.loginView.ViewState;
import sem2.sep2.client.view.manageRoomView.ManageRoomViewModel;
import sem2.sep2.client.view.reserveView.ReserveViewModel;

public class ViewModelFactory {
    private  ModelFactory modelFactory;
    private LoginViewModel clientLoginViewModel;
    private ReserveViewModel clientReserveViewModel;
    private ContactViewModel contactViewModel;
    private ManageRoomViewModel manageRoomViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel() {
        if (clientLoginViewModel == null) {
            clientLoginViewModel = new LoginViewModel(modelFactory.getLoginModel(), modelFactory.getCreateModel());
        }
        return clientLoginViewModel;
    }

    public ReserveViewModel getReserveViewModel() {
        if (clientReserveViewModel == null) {
            clientReserveViewModel = new ReserveViewModel(modelFactory.getReserveModel());
        }
        return clientReserveViewModel;
    }

  public ContactViewModel getContactViewModel()
  {
      if(contactViewModel == null){
          contactViewModel = new ContactViewModel(modelFactory.getContactModel());
      }
      return contactViewModel;
  }

  public ManageRoomViewModel getManageRoomViewModel()
  {
    if(manageRoomViewModel == null){
      manageRoomViewModel = new ManageRoomViewModel(modelFactory.getRoomModel());
    }
    return manageRoomViewModel;
  }
}

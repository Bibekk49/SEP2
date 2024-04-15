package sem2.sep2.client.viewModel;

import sem2.sep2.client.model.ClientModel;

public class ClientViewModelFactory
{
  private final ClientLoginViewModel clientLoginViewModel;
  public ClientViewModelFactory(ClientModel model){
    this.clientLoginViewModel = new ClientLoginViewModel(model);
  }
  public ClientLoginViewModel getClientLoginViewModel(){
    return clientLoginViewModel;
  }
}

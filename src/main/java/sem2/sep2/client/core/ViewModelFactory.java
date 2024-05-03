package sem2.sep2.client.core;

import sem2.sep2.client.core.ModelFactory;
import sem2.sep2.client.viewModel.LoginViewModel;

public class ViewModelFactory
{
  private final ModelFactory modelFactory;
  private LoginViewModel clientLoginViewModel;
  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }
  public LoginViewModel getLoginViewModel(){
    if(clientLoginViewModel==null){
clientLoginViewModel=new LoginViewModel(modelFactory.getLoginViewModel());
    }
    return clientLoginViewModel;
  }
}

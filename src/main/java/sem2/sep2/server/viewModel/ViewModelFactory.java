package sem2.sep2.server.viewModel;

import sem2.sep2.server.model.AdminModel;

public class ViewModelFactory
{
  private final AdminViewModel adminViewModel;
  public ViewModelFactory(AdminModel model){
    this.adminViewModel = new AdminViewModel(model);
  }
  public AdminViewModel getAdminViewModel(){
    return adminViewModel;
  }
}

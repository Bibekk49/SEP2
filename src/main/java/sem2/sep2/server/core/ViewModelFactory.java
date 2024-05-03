package sem2.sep2.server.core;

import sem2.sep2.server.viewModel.ViewModel;

public class ViewModelFactory {
    private final ModelFactory modelFactory;
    private ViewModel viewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ViewModel getLoginViewModel() {
        if (viewModel == null) {
            viewModel = new ViewModel(modelFactory.getAdminModel());
        }
        return viewModel;
    }
}

package sem2.sep2.client.view.historyView;

import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;

public class HistoryViewController implements ViewController
{
  private ViewHandler viewHandler;
  private HistoryViewModel historyViewModel;
  private Region root;
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root){
    this.viewHandler = viewHandler;
    this.historyViewModel = viewModelFactory.getHistoryViewModel();
    this.root = root;
  }
  @Override
  public void reset(){

  }
}
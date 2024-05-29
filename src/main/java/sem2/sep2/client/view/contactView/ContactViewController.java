package sem2.sep2.client.view.contactView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.client.view.loginView.LoginViewModel;

import java.rmi.RemoteException;

public class ContactViewController implements ViewController
{
  private ViewHandler viewHandler;
  private ContactViewModel contactViewModel;
  private Region root;
  @FXML
  private TextArea chatField;
  @FXML
  private TextArea showField;
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.contactViewModel = viewModelFactory.getContactViewModel();

    chatField.textProperty().bindBidirectional(contactViewModel.getChatField());
    showField.textProperty().bindBidirectional(contactViewModel.getShowField());
  }
  @Override
  public void reset(){
    chatField.setText("");
  }
  public void SendButtonPressed(ActionEvent event){
    contactViewModel.sendMessage(viewHandler.getGuest());
    reset();
  }
}

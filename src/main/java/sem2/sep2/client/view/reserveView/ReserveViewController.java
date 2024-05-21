package sem2.sep2.client.view.reserveView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.room.Room;

import java.awt.*;
import java.net.URI;
import java.rmi.RemoteException;
import java.time.LocalDate;

public class ReserveViewController implements ViewController {
    @FXML
    private DatePicker checkInDatePicker;
    @FXML
    private DatePicker checkOutDatePicker;
    @FXML
    private TableView<Room> tableView;
    @FXML
    private TableColumn<Room, String> roomNumberColumn;
    @FXML
    private TableColumn<Room, String> typeColumn;
    @FXML
    private TableColumn<Room, Double> pricePerDayColumn;
    @FXML
    private ChoiceBox roomType;
    @FXML
    private TextField roomNumber;
    private ObservableList<Room> roomData;
    private ViewHandler viewHandler;
    private ReserveViewModel reserveViewModel;
    private Region root;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root){
        this.viewHandler = viewHandler;
        this.reserveViewModel = viewModelFactory.getReserveViewModel();
        this.root = root;

        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        pricePerDayColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        roomType.setItems(FXCollections.observableArrayList("Single", "Double", "Suite"));
        roomType.setValue("Single");

        roomNumber.textProperty().bindBidirectional(reserveViewModel.getRoomNumber());
        this.roomType.valueProperty().bindBidirectional(reserveViewModel.getRoomType());
        this.checkInDatePicker.valueProperty().bindBidirectional(reserveViewModel.getCheckInDatePicker());
        this.checkOutDatePicker.valueProperty().bindBidirectional(reserveViewModel.getCheckOutDatePicker());



        roomData = FXCollections.observableArrayList();
        tableView.setItems(roomData);

        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(LocalDate.now().plusDays(1));

    }
    @Override
    public void reset(){
        roomData.clear();
        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(LocalDate.now().plusDays(1));//default date
    }
    public void SearchButtonPressed(ActionEvent actionEvent) throws Exception
    {
        roomData = (ObservableList<Room>) reserveViewModel.searchRooms();
//       roomData.addAll(loginService.findAvailableRooms(checkInDate,checkOutDate));
        tableView.setItems(roomData);
    }
    public void ContactUsPressed(ActionEvent event)throws Exception{
        viewHandler.openContactView();
    }
    public void AboutPressed(ActionEvent event)throws  Exception{
        String url = "http://royalhotel2.durablesites.com";
        try {
            URI uri = new URI(url);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ChangeProfilePressed(ActionEvent actionEvent){
        viewHandler.openProfileView();
    }
    public void BookingHistory(ActionEvent actionEvent){
        viewHandler.openHistoryView();
    }
    public void Reserve(ActionEvent actionEvent){
        reserveViewModel.Reserve();
    }
    public void Cancel(ActionEvent actionEvent){
        reserveViewModel.Cancel();
    }
}

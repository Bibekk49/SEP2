package sem2.sep2.client.view.reserveView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.room.Room;

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
    private ObservableList<Room> roomData;
    private ViewHandler viewHandler;
    private ReserveViewModel reserveViewModel;
    private Region root;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,
                     Region root) throws RemoteException{
        this.viewHandler = viewHandler;
        this.reserveViewModel = viewModelFactory.getReserveViewModel();
        this.root = root;

        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        pricePerDayColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        roomData = FXCollections.observableArrayList();
        tableView.setItems(roomData);
    }
    @Override
    public void reset(){
        roomData.clear();
    }
    public void SearchButtonPressed(ActionEvent actionEvent) throws Exception
    {
        LocalDate checkInDate = checkInDatePicker.getValue();
        LocalDate checkOutDate = checkOutDatePicker.getValue();
        if (checkInDate == null || checkOutDate == null || checkInDate.isAfter(checkOutDate)) {
            System.out.println("ERROR");
            return;
        }
        reset();
//        roomData.addAll(loginService.findAvailableRooms(checkInDate,checkOutDate));
    }
    public void ContactUsPressed(ActionEvent event)throws Exception{
        viewHandler.openContactView();
    }

}

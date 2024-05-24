package sem2.sep2.client.view.manageRoomView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.room.Room;

import java.sql.Date;


public class ManageRoomViewController implements ViewController {
    private ViewHandler viewHandler;
    private ManageRoomViewModel manageRoomViewModel;
    private Region root;


    @FXML
    private TextField roomNumber;
    @FXML
    private TextField price;
    @FXML
    private ChoiceBox<String> roomType;
    @FXML
    private Text errorTextAdd;


    @FXML
    private TableView<Room> roomTableView;
    @FXML
    private TableColumn<Room, Integer> roomNumberColumn;
    @FXML
    private TableColumn<Room, String> roomTypeColumn;
    @FXML
    private TableColumn<Room, Double> roomPriceColumn;
    @FXML
    private TableColumn<Room, String> roomAvailabilityColumn;


    @FXML
    private TableView<Reservation> reservationTableView;
    @FXML
    private TableColumn<Reservation, Integer> bookingIdColumn;
    @FXML
    private TableColumn<Reservation, String> bookingGuestColumn;
    @FXML
    private TableColumn<Reservation, Date> bookingStartDateColumn;
    @FXML
    private TableColumn<Reservation, Date> bookingEndDateColumn;
    @FXML
    private TableColumn<Reservation, Integer> bookingRoomColumn;


    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
        this.viewHandler = viewHandler;
        this.manageRoomViewModel = viewModelFactory.getManageRoomViewModel();
        this.root = root;
        bindProperties();
    }

    @Override
    public void reset() {

    }

    private void bindProperties() {
        roomNumber.textProperty().bindBidirectional(manageRoomViewModel.getRoomNumber());
        price.textProperty().bindBidirectional(manageRoomViewModel.getPrice());
        roomType.setItems(manageRoomViewModel.getRoomTypes());
        roomType.valueProperty().bindBidirectional(manageRoomViewModel.getRoomType());
        errorTextAdd.textProperty().bind(manageRoomViewModel.getError());



        roomTableView.setItems(manageRoomViewModel.getAllrooms());
        roomTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> manageRoomViewModel.selectedRoomProperty().set(newVal));
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomNumber"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("type"));
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<Room, Double>("price"));
        roomAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("roomAvailability"));


        reservationTableView.setItems(manageRoomViewModel.getAllReservations());
        bookingIdColumn.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("reservationID"));
        bookingGuestColumn.setCellValueFactory(new PropertyValueFactory<Reservation, String>("guestUsername"));
        bookingStartDateColumn.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("startDate"));
        bookingEndDateColumn.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("endDate"));
        bookingRoomColumn.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("roomNumber"));
    }


    public Region getRoot() {
        return root;
    }

    @FXML
    private void addButtonClicked() {
        boolean success = manageRoomViewModel.addRoom();
        manageRoomViewModel.refresh();
        if (success) {
            errorTextAdd.setFill(Color.GREEN);
        } else {
            errorTextAdd.setFill(Color.RED);
        }
    }

    @FXML
    private void editButtonClicked() {

        viewHandler.openEditRoomView();
    }


    public void refreshButtonPressed() {
        manageRoomViewModel.refresh();
        manageRoomViewModel.getAllReservations();
    }


    @FXML
    public void deleteButtonClicked() {
        manageRoomViewModel.deleteRoom();
    }

}



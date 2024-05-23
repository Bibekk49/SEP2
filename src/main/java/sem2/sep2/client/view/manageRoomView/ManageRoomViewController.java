package sem2.sep2.client.view.manageRoomView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.RoomState;
import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.room.Room;


public class ManageRoomViewController implements ViewController
{
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
    private ListView<Room> roomListView = new ListView<>();
    @FXML
    private ListView<Guest> userListView = new ListView<>();

    @FXML
    private TableView<Room> roomList;

    @FXML
    private TableColumn<Room, Integer> roomNumberColumn;

    @FXML
    private TableColumn<Room, String> roomTypeColumn;

    @FXML
    private TableColumn<Room, Double> roomPriceColumn;

    @FXML
    private TableColumn<Room, String> roomAvailabilityColumn;

    @FXML
    private TableColumn<Room, String> roomGuestColumn;
    ObservableList<Room> roomView = FXCollections.observableArrayList();
    ObservableList<Guest> userList = FXCollections.observableArrayList();
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,Region root){
        this.viewHandler = viewHandler;
        this.manageRoomViewModel = viewModelFactory.getManageRoomViewModel();
        this.root = root;

        RoomState roomState = new Available();
        manageRoomViewModel.getRoomModel().createRoom(new Room(101,"Single",1000.0,roomState));

        roomView.addAll(manageRoomViewModel.getAllRooms());
//      userList.addAll(userDao.getAllUsers());

        roomListView.setItems(roomView);
        userListView.setItems(userList);
        bindProperties();



        roomNumber.textProperty().bindBidirectional(manageRoomViewModel.getRoom_id());
        price.textProperty().bindBidirectional(manageRoomViewModel.getPrice());
        roomType.valueProperty().bindBidirectional(manageRoomViewModel.getRoomType());
//        chatField.textProperty().bindBidirectional(manageRoomViewModel.getChatField());
//        showField.textProperty().bindBidirectional(manageRoomViewModel.getShowField());
//        Recipient.textProperty().bindBidirectional(manageRoomViewModel.getRecipient());

        roomType.setItems(FXCollections.observableArrayList("Single", "Double", "Suite"));
        roomType.setValue("Single");
    }

    public void reset() {
        roomNumber.clear();
        price.clear();
        roomType.setValue("Single");
    }
    private void bindProperties() {
        roomList.setItems(roomView);
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomNumber"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("type"));
        roomPriceColumn.setCellValueFactory(new PropertyValueFactory<Room, Double>("price"));
        roomAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("roomAvailability"));
    }

    public void refresh(){
        roomView.clear();
        userList.clear();
        roomView.addAll(manageRoomViewModel.getAllRooms());
//        userList.addAll(userDao.getAllUsers());

        roomListView.setItems(roomView);
        userListView.setItems(userList);
    }

    public Region getRoot() {
        return root;
    }

    //button here rg1
    public void addButtonClicked(ActionEvent actionEvent)
    {
        manageRoomViewModel.addRoom();
        refresh();
    }

    public void editButtonClicked(ActionEvent actionEvent)
    {
        manageRoomViewModel.editRoom();
        refresh();
//        reset();
    }


    //button pg 2/3
    public void DeleteButtonPressed(ActionEvent actionEvent)
    {
        manageRoomViewModel.deleteRoom();
    }
    public void refreshButtonPressed(ActionEvent actionEvent)
    {
        this.refresh();
    }
    public void BookingHistory(ActionEvent actionEvent){
        viewHandler.openHistoryView();
    }
    public void sendButtonPressed(ActionEvent actionEvent){
        manageRoomViewModel.managerResponse();
    }

    public void deleteButtonClicked(ActionEvent actionEvent) {
    }
}



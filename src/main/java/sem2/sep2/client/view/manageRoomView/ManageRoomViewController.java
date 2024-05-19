package sem2.sep2.client.view.manageRoomView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.RoomState;
import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.room.Room;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageRoomViewController implements ViewController
{
    private ViewHandler viewHandler;
    private ManageRoomViewModel manageRoomViewModel;
    private Region root;
    @FXML
    private TextField room_id;
    @FXML
    private TextField price;
    @FXML
    private TextField idnumber;
    @FXML
    private ChoiceBox roomType;
    @FXML
    private ChoiceBox availability;
    @FXML
    private ListView<Room> roomListView = new ListView<>();
    @FXML
    private ListView<Guest> userListView = new ListView<>();
    ObservableList<Room> roomList = FXCollections.observableArrayList();
    ObservableList<Guest> userList = FXCollections.observableArrayList();
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,Region root) throws RemoteException{
        this.viewHandler = viewHandler;
        this.manageRoomViewModel = viewModelFactory.getManageRoomViewModel();
        this.root = root;

//        RoomState roomState = new Available();
//        manageRoomViewModel.getRoomModel().createRoom(new Room(101,"Single",1000.0,roomState));

        roomList.addAll(manageRoomViewModel.getAllRooms());
//      userList.addAll(userDao.getAllUsers());

        roomListView.setItems(roomList);
        userListView.setItems(userList);



        room_id.textProperty().bindBidirectional(manageRoomViewModel.getRoom_id());
        price.textProperty().bindBidirectional(manageRoomViewModel.getPrice());
        idnumber.textProperty().bindBidirectional(manageRoomViewModel.getIdnumber());
        roomType.accessibleTextProperty().bindBidirectional(manageRoomViewModel.getRoomType());

        roomType.setItems(FXCollections.observableArrayList("Single", "Double", "Suite"));
        roomType.setValue("Single");
        availability.setItems(FXCollections.observableArrayList("Available", "Occupied", "Reserved"));
        availability.setValue("Available");

    }

    public void reset() {
        room_id.clear();
        price.clear();
        idnumber.clear();
        roomType.setValue("Single");
        availability.setValue("Available");
    }

    public void refresh(){
        roomList.clear();
        userList.clear();
        roomList.addAll(manageRoomViewModel.getAllRooms());
//        userList.addAll(userDao.getAllUsers());

        roomListView.setItems(roomList);
        userListView.setItems(userList);
    }

    public Region getRoot() {
        return root;
    }

    //button here rg1
    public void AddingButtonPressed(ActionEvent actionEvent)
    {
        manageRoomViewModel.addRoom();

    }

    public void EditingButtonPressed(ActionEvent actionEvent)
    {
//        String id = room_id.getText();
//        String Price = price.getText();
//        String type = (String) roomType.getValue();
//        String available = (String) availability.getValue();
//        if(viewModel.isIntDouble(id)&&viewModel.isIntDouble(Price)){
//            int roomId = Integer.parseInt(id);
//        }
//        refresh();
//        reset();
    }


    //button pg 2/3
    public void DeleteButtonPressed(ActionEvent actionEvent)
    {
        manageRoomViewModel.deleteRoom();
    }
    public void refreshButtonPressed(ActionEvent actionEvent)
        throws SQLException
    {
        this.refresh();
    }
}



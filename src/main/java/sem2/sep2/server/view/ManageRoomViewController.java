package sem2.sep2.server.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sem2.sep2.server.core.ViewHandler;
import sem2.sep2.server.core.ViewModelFactory;
import sem2.sep2.server.viewModel.ViewModel;
import sem2.sep2.shared.util.Guest;
import sem2.sep2.shared.util.Room;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import sem2.sep2.Dao.RoomDao;
import sem2.sep2.Dao.UserDao;

public class ManageRoomViewController implements ViewController{
    private ViewHandler viewHandler;
    private ViewModel viewModel;
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
    UserDao userDao;
    RoomDao roomDao;

    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory,Region root) throws
        RemoteException, SQLException{
        this.viewHandler = viewHandler;
        this.viewModel = viewModelFactory.getLoginViewModel();
        this.root = root;

        String url = "jdbc:postgresql://localhost:5432/postgres";//?currentSchema=jdbc
        String username = "postgres";
        String password = "050420";
        Connection connection = DriverManager.getConnection(url, username, password);
        userDao = new UserDao(connection);
        roomDao = new RoomDao(connection);


        roomList.addAll(roomDao.getAllRooms());
        userList.addAll(userDao.getAllUsers());
        roomListView.setItems(roomList);
        userListView.setItems(userList);



        room_id.setText("");
        price.setText("");
        idnumber.setText("");

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

    public void refresh() throws SQLException {
        roomList.clear();
        userList.clear();

        roomList.addAll(roomDao.getAllRooms());
        userList.addAll(userDao.getAllUsers());

        roomListView.setItems(roomList);
        userListView.setItems(userList);
    }

    public Region getRoot() {
        return root;
    }

    //button here rg1
    public void AddingButtonPressed(ActionEvent actionEvent) throws SQLException
    {
        if(viewModel.confirm()){
            String id = room_id.getText();
            String Price = price.getText();
            String type = (String) roomType.getValue();
            String available = (String) availability.getValue();
            if(viewModel.isIntDouble(id)&&viewModel.isIntDouble(Price)){
                int roomId = Integer.parseInt(id);
                if(!roomDao.isRoomExist(roomId)){
                    Double price_ = Double.parseDouble(Price);
                    roomDao.createRoom(new Room(roomId,type,price_,available));
                    viewModel.alarm("Successfully","Add successfully!");
                }else{
                    viewModel.alarm("Alarm","The room has already exist.");
                }
            }else{
                viewModel.alarm("Alarm","Please check the id and price.");
            }
            refresh();
            reset();
        }

    }

    public void EditingButtonPressed(ActionEvent actionEvent)throws SQLException
    {
        if(viewModel.confirm()){
            String id = room_id.getText();
            String Price = price.getText();
            String type = (String) roomType.getValue();
            String available = (String) availability.getValue();
            if(viewModel.isIntDouble(id)&&viewModel.isIntDouble(Price)){
                int roomId = Integer.parseInt(id);
                if(roomDao.isRoomExist(roomId)){
                    Double price_ = Double.parseDouble(Price);
                    roomDao.deleteRoom(roomId);
                    roomDao.createRoom(new Room(roomId,type,price_,available));
                    viewModel.alarm("Successfully","Editing room successfully.");
                }else{
                    viewModel.alarm("Alarm","The room does not exist");
                }
            }else{
                viewModel.alarm("Alarm","Please check the id and price.");
            }
            refresh();
            reset();
        }

    }


    //button pg 2/3
    public void DeleteButtonPressed(ActionEvent actionEvent)throws SQLException
    {
        String id = idnumber.getText();
        if(viewModel.isIntDouble(id)){
            int roomId = Integer.parseInt(id);
            if(roomDao.isRoomExist(roomId)){
                if(roomDao.deleteRoom(roomId)){
                    viewModel.alarm("Successfully","Delete Successfully");
                }else{
                    viewModel.alarm("Failed","Delete Failed");
                }
            }else{
                viewModel.alarm("Failed","The room doesn't exist");
            }
        }else{
            viewModel.alarm("Alarm","Please check the id.");
        }
        refresh();
        reset();
    }
    public void refreshButtonPressed(ActionEvent actionEvent)
        throws SQLException
    {
        this.refresh();
    }
}



package sem2.sep2.server.view;

import javafx.beans.binding.ObjectExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import sem2.sep2.RoomDao;
import sem2.sep2.UserDao;
import sem2.sep2.server.viewModel.AdminViewModel;
import sem2.sep2.shared.util.Guest;
import sem2.sep2.shared.util.room.Room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageRoomViewController
{
  private ViewHandler viewHandler;
  private AdminViewModel adminViewModel;
  private Region root;
  @FXML
  private ListView<Room> roomListView = new ListView<>();
  @FXML
  private ListView<Guest> userListView = new ListView<>();
  ObservableList<Room> roomList = FXCollections.observableArrayList();
  ObservableList<Guest> userList = FXCollections.observableArrayList();

  public void init(ViewHandler viewHandler, AdminViewModel adminViewModel,Region root)
      throws SQLException
  {
    this.viewHandler = viewHandler;
    this.adminViewModel = adminViewModel;
    this.root = root;

    String url = "jdbc:postgresql://localhost:5432/postgres";//?currentSchema=jdbc
    String username = "postgres";
    String password = "050420";
    Connection connection = DriverManager.getConnection(url, username, password);
    UserDao userDao = new UserDao(connection);
    RoomDao roomDao = new RoomDao(connection);


    roomList.addAll(roomDao.getAllRooms());
    userList.addAll(userDao.getAllUsers());
    roomListView.setItems(roomList);
    userListView.setItems(userList);
  }
  public void reset(){
    //
  }
  public Region getRoot(){
    return root;
  }
}
package sem2.sep2.client.view.manageRoomView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.RoomState;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManageRoomViewModel
{
    private RoomModel roomModel;
    private StringProperty room_id,price,idnumber,roomType;//room_id in page 1 and idnumber in page 2
    public ManageRoomViewModel(RoomModel roomModel) {
        this.roomModel = roomModel;
        room_id = new SimpleStringProperty();
        price = new SimpleStringProperty();
        idnumber = new SimpleStringProperty();
        roomType = new SimpleStringProperty();
    }

    public boolean isIntDouble(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e1) {
            try {
                Double.parseDouble(input);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }
    public StringProperty getRoom_id(){
        return room_id;
    }
    public StringProperty getPrice(){
        return price;
    }
    public StringProperty getIdnumber(){
        return idnumber;
    }
    public StringProperty getRoomType(){
        return roomType;
    }
    public void addRoom(){
        RoomState roomState = new Available();
        try{
            roomModel.createRoom(new Room(Integer.parseInt(room_id.get()),roomType.get(),
                Double.parseDouble(price.get()),roomState));
        } catch (NumberFormatException e) {
          throw new RuntimeException(e);
        }
    }
    public RoomModel getRoomModel(){
        return roomModel;
    }
    public void deleteRoom(){
        RoomState roomState = new Available();
        try{
            roomModel.deleteRoom(new Room(Integer.parseInt(room_id.get())," ",
                0.0,roomState));
        }
        catch (NumberFormatException e)
        {
          throw new RuntimeException(e);
        }
    }
    public ArrayList<Room> getAllRooms(){
        try{
           RoomList roomList = (RoomList) roomModel.getAllRooms().getObject();
           return roomList.getAllRooms();
        }
        catch (Exception e)
        {
          throw new RuntimeException(e);
        }
    }
}

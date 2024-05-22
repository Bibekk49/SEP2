package sem2.sep2.client.view.manageRoomView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.Room.RoomModel;
import sem2.sep2.client.model.contact.ContactModel;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.RoomList;
import sem2.sep2.shared.util.room.roomState.Available;
import sem2.sep2.shared.util.room.roomState.RoomState;
import sem2.sep2.shared.util.users.Guest;

import java.util.ArrayList;

public class ManageRoomViewModel
{
    private RoomModel roomModel;
    private ContactModel contactModel;
    private StringProperty room_id,price,idnumber,roomType;//room_id in page 1 and idnumber in page 2
    private StringProperty showField,chatField,Recipient;
    public ManageRoomViewModel(RoomModel roomModel,ContactModel contactModel) {
        this.roomModel = roomModel;
        this.contactModel = contactModel;
        room_id = new SimpleStringProperty();
        price = new SimpleStringProperty();
        idnumber = new SimpleStringProperty();
        roomType = new SimpleStringProperty();
        showField = new SimpleStringProperty();
        chatField = new SimpleStringProperty();
        Recipient = new SimpleStringProperty();
    }
    public StringProperty getShowField(){
        return showField;
    }
    public StringProperty getChatField(){
        return chatField;
    }
    public StringProperty getRecipient(){
        return Recipient;
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
    public void editRoom(){
        try{
            this.deleteRoom();
            this.addRoom();
        }
        catch (Exception e)
        {
          throw new RuntimeException(e);
        }
    }
    public ArrayList<Room> getAllRooms(){
        try{
            Request request = roomModel.getAllRooms();
            if(request != null && request.getObject() != null) {
                RoomList roomList = (RoomList) request.getObject();
                return roomList.getAllRooms();
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void managerResponse(){
        try{
            contactModel.managerResponse(new Guest(Recipient.get(),"1111"),chatField.get());
        }
        catch (Exception e)
        {
          throw new RuntimeException(e);
        }

    }
}

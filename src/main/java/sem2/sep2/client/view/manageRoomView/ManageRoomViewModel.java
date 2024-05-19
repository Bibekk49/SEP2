package sem2.sep2.client.view.manageRoomView;

import javafx.beans.property.StringProperty;
import sem2.sep2.client.model.Room.RoomModel;

public class ManageRoomViewModel
{
    private RoomModel roomModel;
    private StringProperty room_id,price;
    public ManageRoomViewModel(RoomModel roomModel) {
        this.roomModel = roomModel;
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
}

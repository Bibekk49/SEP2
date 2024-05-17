package sem2.sep2.client.view.manageRoomView;

import sem2.sep2.client.model.Room.RoomModel;

public class ManageRoomViewModel
{
    private RoomModel roomModel;
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
}

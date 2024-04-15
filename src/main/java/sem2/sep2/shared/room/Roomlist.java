package sem2.sep2.shared.room;

import java.util.ArrayList;

public class Roomlist {
    private ArrayList<Room> rooms;
    public Roomlist (){
        rooms=new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public void removeRoom(Room room){
        rooms.remove(room);
    }
}

package sem2.sep2.server.database.room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.roomState.Available;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RoomDAOImplTest
{
  private RoomDAO roomDao;
  @BeforeEach
  public void setUp(){
    roomDao = new RoomDAOImpl();
  }
  @Test
  void testAddRoomSuccess(){
    Room room = new Room(101010,"Single",1000.0,new Available());
    Request request = roomDao.addRoom(room);
    assertEquals("Room added successfully",request.getType());
  }
  @Test
  void testAddRoomFailed(){
    Room room = new Room(101010,"Single",1000.0,new Available());
    Request request = roomDao.addRoom(room);
    assertEquals("Failed to add room",request.getType());
  }
  @Test
  void testUpdateRoom(){
    Room room = new Room(101010,"Single",1000.0,new Available());
    room.checkIn();
    Request request = roomDao.updateRoom(room);
    assertEquals("Room updated successfully",request.getType());
    assertEquals(room,request.getObject());
  }
  @Test
  void testRemoveRoom(){
    Room room = new Room(101010,"Single",1000.0,new Available());
    Request request = roomDao.removeRoom(room);
    assertEquals("Room added successfully",request.getType());
  }
  @Test
  void testGetAllRoom(){
    Request request = roomDao.getAllRooms();
    assertEquals("Rooms fetched successfully",request.getType());
  }
  @Test
  void testGetAllAvailableRooms(){
    Date dateFrom = Date.valueOf(LocalDate.now());
    Date dateTo = Date.valueOf(LocalDate.now().plusDays(1));
    Request request = roomDao.getAvailableRooms(dateFrom,dateTo);
    assertEquals("Rooms fetched successfully",request.getType());
  }
  @Test
  void testGetAllAvailableRoomsByType(){
    LocalDate dateFrom = LocalDate.now();
    LocalDate dateTo = LocalDate.now().plusDays(1);
    Request request = roomDao.getAllAvailableRoomsByType("Single",dateFrom,dateTo);
    assertEquals("Available rooms fetched successfully",request.getType());
  }
}
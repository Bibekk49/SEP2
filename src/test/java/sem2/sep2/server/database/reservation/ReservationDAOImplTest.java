package sem2.sep2.server.database.reservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sem2.sep2.server.database.room.RoomDAOImpl;
import sem2.sep2.shared.util.Request;
import sem2.sep2.shared.util.reservation.Reservation;
import sem2.sep2.shared.util.reservation.ReservationList;
import sem2.sep2.shared.util.room.Room;
import sem2.sep2.shared.util.room.roomState.Available;

import java.sql.Date;
import java.time.LocalDate;
import sem2.sep2.server.database.room.RoomDAO;
import static org.junit.jupiter.api.Assertions.*;

class ReservationDAOImplTest
{
  private ReservationDAO reservationDao;
  private RoomDAO roomDao;
  @BeforeEach
  public void setUp(){
    reservationDao = new ReservationDAOImpl();
    roomDao = new RoomDAOImpl();
  }
  @Test
  void testAddReservationSuccess(){
    Room room = new Room(10111,"Single",1000.0,new Available());
    roomDao.addRoom(room);
    Date dateFrom = Date.valueOf(LocalDate.now());
    Date dateTo = Date.valueOf(LocalDate.now().plusDays(1));
    Reservation reservation = new Reservation(1,10111,"Yang",dateFrom,dateTo);
    Request request = reservationDao.addReservation(reservation);
    assertEquals("Reservation created successfully",request.getType());
  }
  @Test
  void testAddReservationFailed(){
    Date dateFrom = Date.valueOf(LocalDate.now());
    Date dateTo = Date.valueOf(LocalDate.now().plusDays(1));
    Reservation reservation = new Reservation(1,10111,"Yang",dateFrom,dateTo);
    Request request = reservationDao.addReservation(reservation);
    assertEquals("Failed to create reservation",request.getType());
  }
  @Test
  void testCancelReservation(){
    ReservationList reservationList = (ReservationList) reservationDao.getCurrentReservationsByGuest("Yang").getObject();
    Reservation reservation = reservationList.getReservationById(0);
    Request request = reservationDao.cancelReservation(reservation);
    assertEquals("Reservation cancelled successfully",request.getType());
  }
  @Test
  void testGetAllCurrentReservations(){
    Request request = reservationDao.getAllCurrentReservations();
    assertEquals("All current reservations",request.getType());
  }
  @Test
  void testCheckRoomAvailability(){
    Date dateFrom = Date.valueOf(LocalDate.now());
    Date dateTo = Date.valueOf(LocalDate.now().plusDays(1));
    Reservation reservation = new Reservation(1,10111,"Yang",dateFrom,dateTo);
    Boolean isAvailable = reservationDao.checkRoomAvailability(reservation);
    assertTrue(isAvailable);
  }
  @Test
  void testCheckRoomNotAvailability(){
    Date dateFrom = Date.valueOf(LocalDate.now());
    Date dateTo = Date.valueOf(LocalDate.now().plusDays(1));
    Reservation reservation = new Reservation(1,10111,"Yang",dateFrom,dateTo);
    reservationDao.addReservation(reservation);
    Boolean isAvailable = reservationDao.checkRoomAvailability(reservation);
    assertFalse(isAvailable);
    reservationDao.cancelReservation(reservation);
  }
//  @Test
//  void testGetReservationByRoomNumberFailed(){
//    Request request = reservationDao.getReservationByRoomNumber(10111);
//    assertEquals("No reservation found for room "+10111,request.getType());
//  }
//  @Test
//  void testGetReservationByRoomNumberSuccess(){
//    Date dateFrom = Date.valueOf(LocalDate.now());
//    Date dateTo = Date.valueOf(LocalDate.now().plusDays(1));
//    Reservation reservation = new Reservation(1,10111,"Yang",dateFrom,dateTo);
//    reservationDao.addReservation(reservation);
//
//    Request request = reservationDao.getReservationByRoomNumber(10111);
//    assertEquals("Reservation for room "+10111,request.getType());
//
//    reservationDao.cancelReservation(reservation);
//  }


}
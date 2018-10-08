package safety_monitoring;
import java.util.*;

public class VeryImportantCompany {

  private ArrayList<Room> rooms = new ArrayList<Room>();

  public VeryImportantCompany(){
      Window window1 = new Window(1000);
      Window window2 = new Window(1000);

      Door entryDoor = new Door("Entry Door", 1000);
      Door vipDoor = new Door("VIP Door", 1000);

      Room receptionistRoom = new Room("Receptionist Room");
      Room vipRoom = new Room("VIP Room");

      receptionistRoom.addDoor(entryDoor);
      receptionistRoom.addDoor(vipDoor);

      vipRoom.addDoor(vipDoor);
      vipRoom.addWindow(window1);
      vipRoom.addWindow(window2);

      rooms.add(receptionistRoom);
      rooms.add(vipRoom);
  }

  private Room getRoomByName(String roomName) {
      for ( Room room : rooms ) {
          if(room.getName().equals(roomName)) {
              return room;
          }
      }
      return null;
  }

  public String getWindowStatusFromRoom(String roomName, int windowIndex) {
      Room targetRoom = getRoomByName(roomName);
      Window targetWindow = null;
      if(targetRoom == null) {
          return "Target room does not exist.";
      } else {
          try {
              targetWindow = targetRoom.getWindowByIndex(windowIndex);
          }
          catch(IndexOutOfBoundsException exception) {
              return "Target window does not exist.";
          }
          return targetWindow.getState();
      }
  }
  
  public String getDoorStatusFromRoom(String roomName, String doorName) {
      Room targetRoom = getRoomByName(roomName);
      if(targetRoom == null) {
          return "Target room does not exist.";
      } else {
          Door targetDoor = targetRoom.getDoorByName(doorName);
          if(targetDoor == null) {
              return "Target door does not exist.";
          } else {
              return targetDoor.getState();
          }
      }
  }
}

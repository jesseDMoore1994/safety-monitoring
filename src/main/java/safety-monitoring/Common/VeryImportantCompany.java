package safety_monitoring;
import java.util.*;

public class VeryImportantCompany {

  private ArrayList<Room> rooms = new ArrayList<Room>();
  private static VeryImportantCompany singleInstance = null;

  private VeryImportantCompany(){
      Window window1 = new Window(0, 1000);
      Window window2 = new Window(1, 1000);

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

  public String getWindowStatus(int windowIndex) {
      Window targetWindow;
      try {
          targetWindow = getRoomByName("VIP Room").getWindowByIndex(windowIndex);
      }
      catch(IndexOutOfBoundsException exception) {
          return "Target window does not exist.";
      }
      return targetWindow.getState();
      
  }
  
  public String getDoorStatus(String doorName) {
      Door targetDoor = getRoomByName("Receptionist Room").getDoorByName(doorName);
      if(targetDoor == null) {
          return "Target door does not exist.";
      } else {
          return targetDoor.getState();
      }
  }

  public static VeryImportantCompany getInstance() {
      if (singleInstance == null)
          singleInstance = new VeryImportantCompany();
      
      return singleInstance;
  }
}

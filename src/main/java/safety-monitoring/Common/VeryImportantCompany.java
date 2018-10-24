package safety_monitoring;
import java.util.*;

//VeryImportantCompany is a Singleton class since there can only be one VeryImportantCompany

//The very important company is made up of two rooms, VIP Room an receptionist Room
//There are two windows and two doors, the VIP room has both windows (window 0 and 1),
//and it shares a door with the receptionist room ("VIP Door"). The Receptionist room
//has another door called "Entry Door" in addition to the VIP Door. The receptionist 
//Room does not have any windows.
public class VeryImportantCompany {

  //list of rooms
  private ArrayList<Room> rooms = new ArrayList<Room>();
  //there is only one possible instance of VeryImportantCompany, so we have a static reference
  private static VeryImportantCompany singleInstance = null;

  //the constructor is private so it can only be called by the class itself
  private VeryImportantCompany(){
      //create windows for simulation
      Window window1 = new Window(0, 1000);
      Window window2 = new Window(1, 1000);

      //create doors for sumulation
      Door entryDoor = new Door("Entry Door", 1000);
      Door vipDoor = new Door("VIP Door", 1000);

      //create the rooms for the simulation
      Room receptionistRoom = new Room("Receptionist Room");
      Room vipRoom = new Room("VIP Room");

      //add the doors to the receptionist room
      receptionistRoom.addDoor(entryDoor);
      receptionistRoom.addDoor(vipDoor);

      //add the door and windows to the vip room
      vipRoom.addDoor(vipDoor);
      vipRoom.addWindow(window1);
      vipRoom.addWindow(window2);

      //finally, add the rooms to very important companies list of rooms
      rooms.add(receptionistRoom);
      rooms.add(vipRoom);
  }

  //this function will return a room with a name equal to the argument
  //if it exists, otherwise it will return null
  private Room getRoomByName(String roomName) {
      for ( Room room : rooms ) {
          if(room.getName().equals(roomName)) {
              return room;
          }
      }
      return null;
  }


  //this function will return the state of the window with the index equal to the argument
  //from the VIP Room if it exists, otherwise it try to get a window and fail. We catch
  //the error and return an error string.
  //We do not use the receptionist room because it has no windows.
  public String getWindowStatus(int windowIndex) {
      //get window reference
      Window targetWindow;
      try {
          //try to assign the window
          targetWindow = getRoomByName("VIP Room").getWindowByIndex(windowIndex);
      }//if we get an IndexOutOfBoundsException, we know that the index does not exist in the room
      catch(IndexOutOfBoundsException exception) {
          //return error string instead of failing
          return "Target window does not exist.";
      }
      //return the target window state
      return targetWindow.getState();
      
  }
  
  //this function will return the state of the door with the name equal to the argument
  //from the Receptionist Room if it exists, otherwise it try to get a door and get a null
  //value. If the value is null then we return an error string.
  //We use the receptionist room since it has two doors.
  public String getDoorStatus(String doorName) {
      //get target door from room
      Door targetDoor = getRoomByName("Receptionist Room").getDoorByName(doorName);
      //if targetDoor is null then the room name does not exist
      if(targetDoor == null) {
          //return error string
          return "Target door does not exist.";
      } else {
          //return the target door state
          return targetDoor.getState();
      }
  }

  //this is the factory method for the singleton behavior
  public static VeryImportantCompany getInstance() {
      //if we do not have an instance of the class, create it
      if (singleInstance == null)
          singleInstance = new VeryImportantCompany();
      //return the instance
      return singleInstance;
  }
}

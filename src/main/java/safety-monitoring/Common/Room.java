package safety_monitoring;
import java.util.*;

public class Room {

  private ArrayList<Door> doors = new ArrayList<Door>();
  private ArrayList<Window> windows = new ArrayList<Window>();
  private String name;

  public Room(String name) {
      this.name = name;
  }
  
  public void addDoor(Door newDoor) {
      doors.add(newDoor);
  }
  
  public void addWindow(Window newWindow) {
      windows.add(newWindow);
  }

  public String getName() {
      return name;
  }

  public Door getDoorByName(String name) {
      for ( Door door : doors) {
          if(door.getName().equals(name)) {
              return door;
          }
      }
      return null;
  }

  public Window getWindowByIndex(int idx) {
      return windows.get(idx);
  }
}

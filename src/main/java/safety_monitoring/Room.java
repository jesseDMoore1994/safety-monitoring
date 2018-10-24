package safety_monitoring;
import java.util.*;

public class Room {

  private ArrayList<Door> doors = new ArrayList<Door>();
  private Map<String, Door> DoorDict = new HashMap<>();
  private ArrayList<Window> windows = new ArrayList<Window>();
  private String name;

  public Room(String name) {
      this.name = name;
  }
  
  public void addDoor(Door newDoor) {
      DoorDict.put(newDoor.getName(), newDoor);
  }
  
  public void addWindow(Window newWindow) {
      windows.add(newWindow);
  }

  public String getName() {
      return name;
  }

  public Door getDoorByName(String name) {
      return DoorDict.get(name);
  }

  public Window getWindowByIndex(int idx) {
      return windows.get(idx);
  }
}

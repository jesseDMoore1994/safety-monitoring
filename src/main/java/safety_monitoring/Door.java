package safety_monitoring;
import java.util.*;

public class Door {
  private ArrayList<String> doorStates = new ArrayList<String>();
  private String currentDoorState = new String();
  private Random randGen = new Random();
  private Timer stateTimer = new Timer();
  private String doorName;
  private static class MyDoorTimeTask extends TimerTask
  {
      private Door myDoor;
  
      MyDoorTimeTask(Door myDoor) {
          this.myDoor = myDoor;
      }
      public void run()
      {
          this.myDoor.changeState();
      }
  }

  public Door(String doorName, long period){
    doorStates.add("Open.");
    doorStates.add("Closed but not Locked.");
    doorStates.add("Closed and Locked.");
    this.doorName = doorName;
    changeState();
    stateTimer.schedule(new MyDoorTimeTask(this), 0, period);
  }
  
  public String getName() {
    return doorName;
  }
  
  public String getState() {
    return currentDoorState;
  }
  
  public void changeState() {
    currentDoorState = doorStates.get(randGen.nextInt(doorStates.size()));
  }

}

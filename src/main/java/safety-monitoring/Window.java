package safety_monitoring;
import java.util.*;

public class Window {

  private ArrayList<String> windowStates = new ArrayList<String>();
  private String currentWindowState = new String();
  private Random randGen = new Random();
  private Timer stateTimer = new Timer();
  private static class MyWindowTimeTask extends TimerTask
  {
      private Window myWindow;
  
      MyWindowTimeTask(Window myWindow) {
          this.myWindow = myWindow;
      }
      public void run()
      {
          this.myWindow.changeState();
      }
  }

  public Window(long period){
    windowStates.add("Open.");
    windowStates.add("Half Open.");
    windowStates.add("Closed but not Locked.");
    windowStates.add("Closed and Locked.");
    changeState();
    stateTimer.schedule(new MyWindowTimeTask(this), 0, period);
  }
  
  public String getState() {
    return currentWindowState;
  }
  
  public void changeState() {
    currentWindowState = windowStates.get(randGen.nextInt(windowStates.size()));
  }

}

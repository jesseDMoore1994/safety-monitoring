package safety_monitoring;


public class SafetyMonitoring {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());


    Room test = new Room("Test");
    test.addDoor( new Door("Test Door", 5) );
    System.out.print("Door status" + test.getDoorByName("Test Door").getState());
    try {
        Thread.sleep(6000);
    } catch (InterruptedException e) {
        //Do Nothing
    }
    System.out.print("Door Status after sleep" + test.getDoorByName("Test Door").getState());
    }


  }

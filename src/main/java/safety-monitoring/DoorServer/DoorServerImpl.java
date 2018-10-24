package safety_monitoring;
import javax.jws.WebService;
import java.util.*;
import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "safety_monitoring.DoorServer")
public class DoorServerImpl implements DoorServer {
    //Service Implementation

    private HashMap<String, Door> DoorList = new HashMap<String, Door>();

    @Override
    public String DoorServer(String door_sensor) {
        
        // See if we have heard from this sensor. If so, get a reference to it
        safety_monitoring.VeryImportantCompany VIC = new safety_monitoring.VeryImportantCompany();
        HashMap<String, Door> DoorDict = VIC.GetDoorList();
        return DoorDict.getOrDefault(door_sensor, null);
    }




}


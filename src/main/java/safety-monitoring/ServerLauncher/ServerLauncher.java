package safety_monitoring;

import javax.xml.ws.Endpoint;
import safety_monitoring.DoorServerPublisher;
import safety_monitoring.WindowServerPublisher;
import safety_monitoring.VeryImportantCompany;
 
//Endpoint publisher
public class ServerLauncher{
 
	public static void main(String[] args) {
       VeryImportantCompany vic = VeryImportantCompany.getInstance();
	   DoorServerPublisher doors =  new DoorServerPublisher();
	   WindowServerPublisher windows =  new WindowServerPublisher();
       doors.publish();
       windows.publish();
    }
 
}

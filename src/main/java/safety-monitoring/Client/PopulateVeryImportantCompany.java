package safety_monitoring;
 
import java.net.URL;
import java.util.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import safety_monitoring.WindowServer;
import safety_monitoring.DoorServer;
import safety_monitoring.VeryImportantCompany;

public class PopulateVeryImportantCompany{
 
	public static void main(String[] args) throws Exception {
		//Set up targeting information for the window server
		URL location_of_window_wsdl = new URL("http://localhost:8081/window?wsdl");
		QName name_of_window_service = new QName("http://safety_monitoring/", "WindowServerImplService");

		//create the server from the published wsdl document
		Service windowService = Service.create(location_of_window_wsdl, name_of_window_service);
		WindowServer windowServer = windowService.getPort(WindowServer.class);

		//Set up targeting information for the door server
		URL location_of_door_wsdl = new URL("http://localhost:8080/door?wsdl");
		QName name_of_door_service = new QName("http://safety_monitoring/", "DoorServerImplService");

		//create the server from the published wsdl document
		Service doorService = Service.create(location_of_door_wsdl, name_of_door_service);
		DoorServer door = doorService.getPort(DoorServer.class);

		//Create a Very Important Company
		VeryImportantCompany vic = VeryImportantCompany.getInstance();
		ArrayList<Window> windows = vic.getWindows();
		for (Window window: windows){
			if(windowServer.AddWindow(window.getName())){
				System.out.println("Added "+window.getName());
			} else {
				System.out.println("Failed to add "+window.getName());
			}
		}
    }
 
}


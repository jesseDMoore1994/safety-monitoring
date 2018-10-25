package safety_monitoring;
 
import java.net.URL;
import java.util.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import safety_monitoring.WindowServer;
import safety_monitoring.DoorServer;

public class SafetyMonitoringClient{
 
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
		DoorServer doorServer = doorService.getPort(DoorServer.class);

		
        //If the first arg is the string "Window", we are selecting from the window interface
        if(args[0].equals("Window"))
        {
            //use the wsdl interface and print out the response
	        String response = windowServer.WindowServer(args[1]);
            System.out.println(response);
        } else if (args[0].equals("Door")) //If the first arg is the string "Door", we are selecting from the door interface
        {
            //use the wsdl interface and print out the response
	        String response = doorServer.DoorServer(args[1]);
            System.out.println(response);
        } else if(args[0].equals("Room"))
        {
			// find the room
			VeryImportantCompany vic = VeryImportantCompany.getInstance();
			Room room = vic.getRoomByName(args[1]);
			
			if (room != null){
				ArrayList<Window> windows = room.getWindows();
				System.out.println("--Windows in "+args[1]+"--");
				for (Window window : windows){
					//use the wsdl interface and print out the response
					String response = windowServer.WindowServer(window.getName());
					System.out.println(window.getName()+": "+response);
				}
				System.out.println("\n--Doors in "+args[1]+"--");
				//Door
			} else {
				System.out.println(args[1]+" is not a room at Very Important Company");
			}
        } else { //else we have an incorrect argument, print out an error
            String errStr = "First argument not recognized, select door sensors with the string ";
            errStr += "\"Door\" or window sensors with the string \"Window\" as the first argument.";
            System.out.println(errStr);
        }
    }
 
}

package safety_monitoring;
 
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import safety_monitoring.WindowServer;
import safety_monitoring.DoorServer;

public class SafetyMonitoringClient{
 
	public static void main(String[] args) throws Exception {
        //If the first arg is the string "Window", we are selecting from the window interface
        if(args[0].equals("Window"))
        {
            //Set up targeting information for the window server
    	    URL location_of_wsdl = new URL("http://localhost:8081/window?wsdl");
            QName name_of_service = new QName("http://safety_monitoring/", "WindowServerImplService");

            //create the server from the published wsdl document
            Service windowService = Service.create(location_of_wsdl, name_of_service);
            WindowServer window = windowService.getPort(WindowServer.class);

            //use the wsdl interface and print out the response
	        String response = window.WindowServer(args[1]);
            System.out.println(response);
        } else if (args[0].equals("Door")) //If the first arg is the string "Door", we are selecting from the door interface
        {
            //Set up targeting information for the door server
    	    URL location_of_wsdl = new URL("http://localhost:8080/door?wsdl");
            QName name_of_service = new QName("http://safety_monitoring/", "DoorServerImplService");

            //create the server from the published wsdl document
            Service doorService = Service.create(location_of_wsdl, name_of_service);
            DoorServer door = doorService.getPort(DoorServer.class);

            //use the wsdl interface and print out the response
	        String response = door.DoorServer(args[1]);
            System.out.println(response);
        } else { //else we have an incorrect argument, print out an error
            String errStr = "First argument not recognized, select door sensors with the string ";
            errStr += "\"Door\" or window sensors with the string \"Window\" as the first argument.";
            System.out.println(errStr);
        }
    }
 
}

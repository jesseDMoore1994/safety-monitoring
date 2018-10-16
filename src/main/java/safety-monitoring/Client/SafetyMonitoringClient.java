package safety_monitoring;
 
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import safety_monitoring.WindowServer;
import safety_monitoring.DoorServer;

/* This example does not use wsimport. Instead, it
creates a service instance manually. */
 
public class SafetyMonitoringClient{
 
	public static void main(String[] args) throws Exception {
        if(args[0].equals("Window"))
        {
    	    URL location_of_wsdl = new URL("http://localhost:8080/window?wsdl");
            QName name_of_service = new QName("http://safety_monitoring/", "WindowServerImplService");
            Service windowService = Service.create(location_of_wsdl, name_of_service);
            WindowServer window = windowService.getPort(WindowServer.class);
	        String response = window.WindowServer(Integer.parseInt(args[1]));
            System.out.println(response);
        } else if (args[0].equals("Door"))
        {
    	    URL location_of_wsdl = new URL("http://localhost:8080/door?wsdl");
            QName name_of_service = new QName("http://safety_monitoring/", "DoorServerImplService");
            Service doorService = Service.create(location_of_wsdl, name_of_service);
            DoorServer door = doorService.getPort(DoorServer.class);
	        String response = door.DoorServer(args[1]);
            System.out.println(response);
        } else {
            String errStr = "First argument not recognized, select door sensors with the string ";
            errStr += "\"Door\" or window sensors with the string \"Window\" as the first argument.";
            System.out.println(errStr);
        }
    }
 
}

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
 
	URL location_of_wsdl = new URL("http://localhost:8080/window?wsdl");
 
        QName name_of_service = new QName("http://windowserver/", "WindowServerImplService");
 
        Service windowService = Service.create(location_of_wsdl, name_of_service);
 
        WindowServer hello = windowService.getPort(WindowServer.class);


	String response = hello.WindowServer(args[0]);
 
        System.out.println(response);
 
    }
 
}
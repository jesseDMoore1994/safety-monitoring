package safety_monitoring;

import javax.xml.ws.Endpoint;
import safety_monitoring.WindowServerImpl;
 
//Endpoint publisher
public class WindowServerPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8080/window", new WindowServerImpl());
    }
 
}
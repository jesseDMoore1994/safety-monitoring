package safety_monitoring;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "safety_monitoring.DoorServer")
public class DoorServerImpl implements DoorServer{
 
	@Override
	public String DoorServer(String name) {

		System.out.println(name+" says hello");
		return "Hello World " + name;
	}
 
}
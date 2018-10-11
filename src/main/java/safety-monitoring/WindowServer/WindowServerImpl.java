package safety_monitoring;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "safety_monitoring.WindowServer")
public class WindowServerImpl implements WindowServer{
 
	@Override
	public String WindowServer(String name) {

		System.out.println(name+" says hello");
		return "Hello World " + name;
	}
 
}
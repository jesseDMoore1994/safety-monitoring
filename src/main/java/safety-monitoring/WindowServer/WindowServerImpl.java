package safety_monitoring;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "safety_monitoring.WindowServer")
public class WindowServerImpl implements WindowServer{
 
	@Override
	public String WindowServer(int window_index) {

		return "Half Open.";
	}
 
}

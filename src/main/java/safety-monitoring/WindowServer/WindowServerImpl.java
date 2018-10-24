package safety_monitoring;

import java.util.*;

import javax.jws.WebService;
 
//Service Implementation
@WebService(endpointInterface = "safety_monitoring.WindowServer")
public class WindowServerImpl implements WindowServer{
 
	private ArrayList<Window> windowList;

	@Override
	public String WindowServer(String window_sensor) {
		// See if we have heard from this sensor. If so, get a reference to it
		Window targetWindow = null;
		for ( Window window : windowList) {
			if(window.getName().equals(window_sensor)) {
				targetWindow = window;
			}
		}
		if (targetWindow == null){
			// we haven't heard from this sensor before. Add it to the list

			Window newWindow = new Window(window_sensor, 1000);
			windowList.add(newWindow);
			targetWindow = newWindow;
		}
		return targetWindow.getState();
	}
 
}

import java.io.PrintStream;
import java.util.*;
import safety_monitoring.VeryImportantCompany;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
 
class VeryImportantCompanyTest {

    private VeryImportantCompany vic = new VeryImportantCompany();
    private ArrayList<String> expectedWindowReturns = new ArrayList<String>();
    private ArrayList<String> expectedDoorReturns = new ArrayList<String>();


    private boolean stringInArr(String target, ArrayList<String> arr) {
        for ( String str : arr) {
            if ( str.equals(target) ) {
                return true;
            }
        }
        return false;
    }

    public VeryImportantCompanyTest () {
        expectedWindowReturns.add("Open.");
        expectedWindowReturns.add("Half Open.");
        expectedWindowReturns.add("Closed but not Locked.");
        expectedWindowReturns.add("Closed and Locked.");
        expectedDoorReturns.add("Open.");
        expectedDoorReturns.add("Closed but not Locked.");
        expectedDoorReturns.add("Closed and Locked.");
    }
 
    @Test
    void testGetWindowStatusFromRoom() {
		assertTrue(stringInArr(vic.getWindowStatusFromRoom("VIP Room", 0), expectedWindowReturns));
		assertTrue(stringInArr(vic.getWindowStatusFromRoom("VIP Room", 1), expectedWindowReturns));
		assertEquals(vic.getWindowStatusFromRoom("VIP Room", 3), "Target window does not exist.");
		assertEquals(vic.getWindowStatusFromRoom("Fake Room", 0), "Target room does not exist.");
    }
 
    @Test
    void testGetDoorStatusFromRoom() {
		assertTrue(stringInArr(vic.getDoorStatusFromRoom("VIP Room", "VIP Door"), expectedDoorReturns));
        assertTrue(stringInArr(vic.getDoorStatusFromRoom("Receptionist Room", "Entry Door"), expectedDoorReturns));
        assertTrue(stringInArr(vic.getDoorStatusFromRoom("Receptionist Room", "VIP Door"), expectedDoorReturns));
		assertEquals(vic.getDoorStatusFromRoom("Fake Room", "VIP Door"), "Target room does not exist.");
		assertEquals(vic.getDoorStatusFromRoom("VIP Room", "Fake Door"), "Target door does not exist.");
    }
 
    @Test
    void testCheckVIPRoomBoundaries() {
		assertTrue(stringInArr(vic.getDoorStatusFromRoom("VIP Room", "VIP Door"), expectedDoorReturns));
		assertEquals(vic.getDoorStatusFromRoom("VIP Room", "Entry Door"), "Target door does not exist.");
		assertTrue(stringInArr(vic.getWindowStatusFromRoom("VIP Room", 0), expectedWindowReturns));
		assertTrue(stringInArr(vic.getWindowStatusFromRoom("VIP Room", 1), expectedWindowReturns));
		assertEquals(vic.getWindowStatusFromRoom("VIP Room", 2), "Target window does not exist.");
    }
 
    @Test
    void testCheckReceptionistRoomBoundaries() {
		assertTrue(stringInArr(vic.getDoorStatusFromRoom("Receptionist Room", "VIP Door"), expectedDoorReturns));
		assertTrue(stringInArr(vic.getDoorStatusFromRoom("Receptionist Room", "Entry Door"), expectedDoorReturns));
		assertEquals(vic.getDoorStatusFromRoom("Receptionist Room", "Fake Door"), "Target door does not exist.");
		assertEquals(vic.getWindowStatusFromRoom("Receptionist Room", 0), "Target window does not exist.");
    }
}

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

    private boolean stringInArr(String target, ArrayList<String> arr) {
        for ( String str : arr) {
            if ( str.equals(target) ) {
                return true;
            }
        }
        return false;
    }
 
    @Test
    void testGetWindowStatusFromRoom() {
        ArrayList<String> expectedReturns = new ArrayList<String>();
        expectedReturns.add("Open.");
        expectedReturns.add("Half Open.");
        expectedReturns.add("Closed but not Locked.");
        expectedReturns.add("Closed and Locked.");
		assertTrue(stringInArr(vic.getWindowStatusFromRoom("VIP Room", 0), expectedReturns));
		assertTrue(stringInArr(vic.getWindowStatusFromRoom("VIP Room", 1), expectedReturns));
		assertEquals(vic.getWindowStatusFromRoom("VIP Room", 3), "Target window does not exist.");
		assertEquals(vic.getWindowStatusFromRoom("Fake Room", 0), "Target room does not exist.");
    }
 
    @Test
    void testGetDoorStatusFromRoom() {
        ArrayList<String> expectedReturns = new ArrayList<String>();
        expectedReturns.add("Open.");
        expectedReturns.add("Closed but not Locked.");
        expectedReturns.add("Closed and Locked.");
		assertTrue(stringInArr(vic.getDoorStatusFromRoom("VIP Room", "VIP Door"), expectedReturns));
        assertTrue(stringInArr(vic.getDoorStatusFromRoom("Receptionist Room", "Entry Door"), expectedReturns));
        assertTrue(stringInArr(vic.getDoorStatusFromRoom("Receptionist Room", "VIP Door"), expectedReturns));
		assertEquals(vic.getDoorStatusFromRoom("Fake Room", "VIP Door"), "Target room does not exist.");
		assertEquals(vic.getDoorStatusFromRoom("VIP Room", "Fake Door"), "Target door does not exist.");
    }
}

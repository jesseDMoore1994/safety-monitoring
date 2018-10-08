import java.io.PrintStream;
import safety_monitoring.Greeter;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
 
class GreeterTest {
 
    @Test
    void testSayHello() {
        Greeter test_greeter = new Greeter();
        String hello_str = test_greeter.sayHello();
        assertEquals(hello_str, "Hello world!");
    }
}

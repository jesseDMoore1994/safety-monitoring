import java.io.PrintStream;
import hello.HelloWorld;
import org.junit.jupiter.api.Test;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
 
class HelloWorldTest {
 
    @Test
    void testMainFunction() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        HelloWorld.main(new String[]{});
        verify(out).println(matches("Hello world!"));
    }
}

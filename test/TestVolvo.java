import org.junit.*;
import static org.junit.Assert.*;

public class TestVolvo {

    Volvo240 v;

    @Before
    public void beforeInitVolvo() {
        v = new Volvo240();
    }

    @Test
    public void testIsSpeedFactorCorrect() {
        assert(v.speedFactor() < 1.3 && v.speedFactor() > 1.2);
    }
}

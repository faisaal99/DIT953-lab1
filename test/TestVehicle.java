import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests on the vehicle class
 */
public class TestVehicle {

    Saab95 s;
    Volvo240 v;

    @Before
    public void beforeTestVehicle() {
        s = new Saab95();
        v = new Volvo240();

        s.setCurrentSpeed(10);
        v.setCurrentSpeed(10);
    }

    @Test
    public void testDoesSpeedIncreaseWithVolvo() {
        double beforeSpeed = v.getCurrentSpeed();
        v.gas(0.1);
        assert(beforeSpeed < v.getCurrentSpeed());
    }

    @Test
    public void testDoesSpeedIncreaseWithSaab() {
        double beforeSpeed = s.getCurrentSpeed();
        s.gas(0.1);
        assert(beforeSpeed < s.getCurrentSpeed());
    }

    @Test
    public void testDoesSpeedDecreaseWithVolvo() {
        double beforeSpeed = v.getCurrentSpeed();
        v.brake(0.1);
        assert(beforeSpeed > v.getCurrentSpeed());
    }

    @Test
    public void testDoesSpeedDecreaseWithSaab() {
        double beforeSpeed = s.getCurrentSpeed();
        s.brake(0.1);
        assert(beforeSpeed > s.getCurrentSpeed());
    }

}

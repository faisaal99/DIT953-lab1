// Written by: Faisal Akhtar, Hugo Nordlund, William Kangas

import org.junit.*;
import static org.junit.Assert.*;

public class TestSaab {

    Saab95 s;

    @Before
    public void beforeInitSaab() {
        s = new Saab95();
    }

    @Test
    public void testTurboOffCorrectSpeedFactor() {
        s.setTurboOff();

        assert(s.speedFactor() > 1.24 && s.speedFactor() < 1.26);
    }

    @Test
    public void testTurboOnCorrectSpeedFactor() {
        s.setTurboOn();

        assert(s.speedFactor() > 1.62 && s.speedFactor() < 1.64);
    }
}

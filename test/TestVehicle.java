import org.junit.*;

import java.awt.*;
import java.util.Objects;

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

    @Test
    public void testDoesSpeedStayBelowEnginePower() {
        v.setCurrentSpeed(v.getEnginePower());
        s.setCurrentSpeed(s.getEnginePower());

        v.gas(1);
        s.gas(1);

        assert(v.getCurrentSpeed() == v.getEnginePower() && s.getCurrentSpeed() == s.getEnginePower());
    }

    @Test
    public void testDoesSpeedStayAboveZero() {
        v.setCurrentSpeed(0);
        s.setCurrentSpeed(0);

        v.brake(1);
        s.brake(1);

        assert(v.getCurrentSpeed() == 0 && s.getCurrentSpeed() == 0);
    }

    @Test
    public void testTurningRightPointsToCorrectDirection() {
        v.setDirection(Vehicle.Direction.UP);

        for (int i = 0; i < 4; i++) {
            Vehicle.Direction volvoDirectionBefore = v.getDirection();
            v.turnRight();

            switch (volvoDirectionBefore) {
                case UP    -> { assert(v.getDirection() == Vehicle.Direction.RIGHT); }
                case RIGHT -> { assert(v.getDirection() == Vehicle.Direction.DOWN); }
                case DOWN  -> { assert(v.getDirection() == Vehicle.Direction.LEFT); }
                case LEFT  -> { assert(v.getDirection() == Vehicle.Direction.UP); }
            }
        }
    }

    @Test
    public void testTurningLeftPointsToCorrectDirection() {
        v.setDirection(Vehicle.Direction.UP);

        for (int i = 0; i < 4; i++) {
            Vehicle.Direction volvoDirectionBefore = v.getDirection();
            v.turnLeft();

            switch (volvoDirectionBefore) {
                case UP    -> { assert(v.getDirection() == Vehicle.Direction.LEFT);  }
                case RIGHT -> { assert(v.getDirection() == Vehicle.Direction.UP);    }
                case DOWN  -> { assert(v.getDirection() == Vehicle.Direction.RIGHT); }
                case LEFT  -> { assert(v.getDirection() == Vehicle.Direction.DOWN);  }
            }
        }
    }

    @Test
    public void testDoesMovingInXAxisWorkCorrectly() {
        s.setPosition(new Vehicle.Position(0, 0));
        v.setPosition(new Vehicle.Position(0,0));
        s.setDirection(Vehicle.Direction.RIGHT);
        v.setDirection(Vehicle.Direction.LEFT);

        s.move();
        v.move();

        assert(s.getPosition().getX() == 10 && v.getPosition().getX() == -10);
    }

    @Test
    public void testDoesMovingInYAxisWorkCorrectly() {
        s.setPosition(new Vehicle.Position(0, 0));
        v.setPosition(new Vehicle.Position(0,0));
        s.setDirection(Vehicle.Direction.DOWN);
        v.setDirection(Vehicle.Direction.UP);

        s.move();
        v.move();

        assert(s.getPosition().getY() == 10 && v.getPosition().getY() == -10);
    }

    @Test
    public void testIsEngineStartSpeedCorrect() {
        s.startEngine();
        v.startEngine();

        assert(s.getCurrentSpeed() == 0.1 && v.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testDoesPositionEqualsWorkCorrectly(){
        Object o = 10;
        Saab95 s2 = new Saab95();
        s2.setPosition(null);

        assert (v.getPosition().equals(s.getPosition()));
        assert (!(v.getPosition().equals(o)) );
        assert (!(v.getPosition().equals(s2.getPosition())));
    }

    @Test
    public void testDoesGettersWorkCorrectly(){

        assert (s.getNrDoors() == 2 && v.getNrDoors() == 4);
        assert (s.getColor() == Color.red && v.getColor() == Color.black);
        assert (s.getModelName().equals("Saab95"));
        assert (v.getModelName().equals("Volvo240"));
    }


}

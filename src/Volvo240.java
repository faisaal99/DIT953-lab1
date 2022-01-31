// Written by: Faisal Akhtar, Hugo Nordlund, William Kangas

import java.awt.*;

public class Volvo240 extends Vehicle {


    public final static double trimFactor = 1.25;

    Vehicle vehicle;
    /**
     * Sole constructor
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");

        stopEngine();
    }

    /**
     * calculates the maximum possible acceleration and deceleration
     * @return the maximum possible acceleration and deceleration of this object
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}

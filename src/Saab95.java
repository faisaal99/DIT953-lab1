// Written by: Faisal Akhtar, Hugo Nordlund, William Kangas

import java.awt.*;

public class Saab95 extends Vehicle {

    /**
     * Makes the car run faster
     */
    private boolean turboOn;

    /**
     * Sole constructor
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
	    setTurboOff();

        stopEngine();
    }

    /**
     * Sets turboOn to true
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets turboOn to false
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Calculates the maximum possible acceleration and deceleration
     * @return the maximum possible acceleration and deceleration of this object
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        
        if (turboOn)
            turbo = 1.3;
        
        return getEnginePower() * 0.01 * turbo;
    }
    
}

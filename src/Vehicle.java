/*public abstract ass_class Vehicle {
    BigBooty hugo = new BigBooty();
}*/

import java.awt.*;

/**
 * TODO Not Commented
 */
public abstract class Vehicle implements Movable {

    private final int nrDoors;        // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed;      // The current speed of the car
    private Color color;              // Color of the car
    private final String modelName;   // The car model name
    private int x;               // The vehicles x-coordinate
    private int y;               // The vehicles y-coordinate
    // TODO Decide how direction should be represented

    public Vehicle(
        int nrDoors, 
        double enginePower, 
        Color color,
        String modelName) {
            this.nrDoors      = nrDoors;
            this.enginePower  = enginePower;
            this.color        = color;
            this.modelName    = modelName;
            this.x            = 0;
            this.y            = 0;
    }

    // region GETTERS n SETTERS

    public int getNrDoors()         { return nrDoors; }
    public double getEnginePower()  { return enginePower; }
    public double getCurrentSpeed() { return currentSpeed; }
    public Color getColor()         { return color; }
    public String getModelName()    { return modelName; }
    public int getX()               { return x; }
    public int getY()               { return y; }

    public void setColor(Color clr) { color = clr; }
    public void setY(int y)         { this.y = y; }
    public void setX(int x)         { this.x = x; }

    // endregion

    // region IMPLEMENTED METHODS

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    // endregion

    /**
     * Increases the speed of the vehicle.
     * @param amount The factor to increase by.
     */
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decreases the speed of the vehicle
     * @param amount The factor to decrease by.
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public abstract double speedFactor();
}

/*public abstract ass_class Vehicle {
    BigBooty hugo = new BigBooty();
}*/

import java.awt.*;

public abstract class Vehicle {

    private int nrDoors;         // Number of doors on the car
    private double enginePower;  // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color;         // Color of the car
    private String modelName;    // The car model name

    public Vehicle(
        int nrDoors, 
        double enginePower, 
        Color color,
        String modelName) {
            this.nrDoors      = nrDoors;
            this.enginePower  = enginePower;
            this.color        = color;
            this.modelName    = modelName;
    }

    // region GETTERS n SETTERS

    public int getNrDoors()         { return nrDoors; }
    public double getEnginePower()  { return enginePower; }
    public double getCurrentSpeed() { return currentSpeed; }
    public Color getColor()         { return color; }
    public String getModelName()    { return modelName; }

    public void setColor(Color clr){
	    color = clr;
    }

    // endof GETTERS n SETTERS

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public abstract double speedFactor();
}

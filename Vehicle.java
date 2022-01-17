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

    public Vehicle() {
        // TODO muthafuckaaaa
    }

    // region GETTERS n SETTERS

    public int getNrDoors() { return nrDoors; }
    public double getEnginePower() { return enginePower; }
    public double getCurrentSpeed() { return currentSpeed; }
    public Color getColor() { return color; }
    public String getModelName() { return modelName; }

    // endof GETTERS n SETTERS
}

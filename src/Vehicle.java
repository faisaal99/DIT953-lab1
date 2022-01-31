// Written by: Faisal Akhtar, Hugo Nordlund, William Kangas

import java.awt.*;

/**
 * Class for holding information about a vehicle
 */
public abstract class Vehicle implements IMovable {

    private final int    nrDoors;      // Number of doors on the car
    private final double enginePower;  // Engine power of the car
    private double       currentSpeed; // The current speed of the car
    private Color        color;        // Color of the car
    private final String modelName;    // The car model name

    // Properties for position and movement
    private Position position;
    private Direction direction;

    /**
     * Sole constructor
     * (For invocation by subclass constructors)
     * @param nrDoors The number of doors for the vehicle
     * @param enginePower The power of the engine
     * @param color The color of the class
     * @param modelName The model of the car
     */
    public Vehicle(
        int nrDoors, 
        double enginePower, 
        Color color,
        String modelName
    ) {
            this.nrDoors     = nrDoors;
            this.enginePower = enginePower;
            this.color       = color;
            this.modelName   = modelName;

            position  = new Position(0, 0);
            direction = Direction.DOWN;
    }

    // region GETTERS n SETTERS

    public int       getNrDoors()      { return nrDoors;      }
    public double    getEnginePower()  { return enginePower;  }
    public double    getCurrentSpeed() { return currentSpeed; }
    public Color     getColor()        { return color;        }
    public String    getModelName()    { return modelName;    }
    public Direction getDirection()    { return direction;    }
    public Position  getPosition()     { return position;     }

    // Setters used for testing | Not for production
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }
    public void setDirection(Direction direction)    { this.direction    = direction;    }
    public void setPosition(Position position)       { this.position     = position;     }
    public void setColor(Color color)                { this.color        = color;        }

    // endregion

    // region IMPLEMENTED METHODS

    /**
     * Changes the position of the vehicle.
     * @see #getCurrentSpeed()
     * @see #direction
     */
    @Override
    public void move() {
        int speed = (int) getCurrentSpeed();
        switch (direction) {
            case UP    -> position.setY(position.getY() - speed);
            case RIGHT -> position.setX(position.getX() + speed);
            case DOWN  -> position.setY(position.getY() + speed);
            case LEFT  -> position.setX(position.getX() - speed);
        }
    }

    /**
     * Changes direction of the vehicle to the left.
     */
    @Override
    public void turnLeft() {
        switch (direction) {
            case UP    -> direction = Direction.LEFT;
            case LEFT  -> direction = Direction.DOWN;
            case DOWN  -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.UP;
        }

    }

    /**
     * Changes direction of the vehicle to the right.
     */
    @Override
    public void turnRight() {
        switch (direction) {
            case UP    -> direction = Direction.RIGHT;
            case LEFT  -> direction = Direction.UP;
            case DOWN  -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.DOWN;
        }
    }

    // endregion

    /**
     * Determines the speed factor
     * @return The speed factor
     */
    protected abstract double speedFactor();

    /**
     * Increases the speed of the vehicle.
     * @param amount The factor to increase by.
     */
    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decreases the speed of the vehicle
     * @param amount The factor to decrease by.
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Accelerates the vehicle
     * @param amount Intensity of acceleration (must be in the range [0, 1])
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * Decelerates the vehicle
     * @param amount Intensity of brake (must be in the range [0, 1])
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }

    /**
     * Sets the vehicle's speed to barely moving.
     */
    public void startEngine() {
	    currentSpeed = 0.1;
    }

    /**
     * Sets the vehicle's speed to a complete stop.
     */
    public void stopEngine() {
	    currentSpeed = 0;
    }

    /**
     * Holds information about the direction of the vehicle
     */
    enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    /**
     * Holds information about the location of the vehicle
     */
    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x; 
            this.y = y; 
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;

            if (!(o instanceof Position p))
                return false;

            return p.x == this.x && p.y == this.y;
        }
    }
}
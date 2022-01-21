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
    private int x;                    // The vehicles x-coordinate
    private int y;                    // The vehicles y-coordinate

    // Properties for position and movement
    private Position position;
    private Direction direction;

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

            position = new Position(0, 0);
            direction = Direction.DOWN;
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
        int speed = (int) getCurrentSpeed();
        switch (direction) {
            case UP    -> position.setY(position.getY() - speed);
            case RIGHT -> position.setX(position.getX() + speed);
            case DOWN  -> position.setY(position.getY() + speed);
            case LEFT  -> position.setX(position.getX() - speed);
        }
    }

    @Override
    public void turnLeft() {
        switch (direction) {
            case UP    -> direction = Direction.LEFT;
            case LEFT  -> direction = Direction.DOWN;
            case DOWN  -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.UP;
        }

    }

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

    enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x; 
            this.y = y; 
        }

        public int getX() { return x; }
        public int getY() { return y; }
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
    }
}
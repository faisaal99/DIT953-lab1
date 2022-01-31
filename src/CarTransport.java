import util.Tray;

import java.awt.*;

public class CarTransport extends Vehicle {

    Vehicle vehicle;
    Tray tray;

    public CarTransport() {
        super(2, 240, Color.BLACK, "CTT");

        // Vehicle klassen är för nuvarande abstract och kan inte instantiseras
        // vehicle = new Vehicle(2, 240, Color.BLACK, "CTT");


    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}

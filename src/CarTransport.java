import util.CarTransportTray;
import util.Tray;

import java.awt.*;

public class CarTransport extends Vehicle {

    Vehicle vehicle;
    CarTransportTray tray;

    public CarTransport() {
        super(2, 240, Color.BLACK, "CTT");

        tray = new CarTransportTray();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}

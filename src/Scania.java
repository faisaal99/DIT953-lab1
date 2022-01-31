import java.awt.*;

public class Scania extends Vehicle {

    int tray;

    public Scania() {
        super(
        2,
        200,
        Color.gray,
        "Scania"
        );

        tray = 0;
    }

    void raise(int inc){
        if ( !(getCurrentSpeed() > 0)) {
            tray = Math.min(tray + inc, 70);
        }
    }

    void lower(int inc) {
        if ( !(getCurrentSpeed() > 0)) {
            tray = Math.max(tray - inc, 0);
        }
    }

    @Override
    public void move() {
        if (tray == 0) {
            super.move();
        }
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}

package util;

public class CarTransportTray {

    private final Tray tray;
    private boolean isLowered;

    /**
     * Constructor
     */
    public CarTransportTray() {
        tray = new Tray();
        isLowered = true;
    }

    // region GETTERS n SETTERS

    public boolean getIsLowered() { return isLowered; }
    public Tray getTray()         { return tray;      }

    // endregion

    public void setToLoweredPosition() {
        tray.raiseTray(Tray.MAX_ANGLE);
        isLowered = true;
    }

    public void setToRaisedPosition() {
        tray.lowerTray(Tray.MAX_ANGLE);
        isLowered = false;
    }
}

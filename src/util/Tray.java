package util;

/**
 * Represents the tray of a truck
 */
public class Tray {

    public static int MAX_ANGLE = 70;
    public static int MIN_ANGLE = 0;

    private int trayPosition = 0;

    void raiseTray(int by) {
        trayPosition = Math.min(trayPosition + by, MAX_ANGLE);
    }

    void lowerTray(int by) {
        trayPosition = Math.max(trayPosition - by, MIN_ANGLE);
    }
}

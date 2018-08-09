package Device;

import Tools.Utils;
import Tools.ToolsVersion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Device {

    // Version number
    private String version;
    // Name of the device
    private String nameDevice;

    /**
     * Constructor of device class
     *
     * @param nameDevice Name of the device
     * @param version    Version number
     */
    public Device(String nameDevice, String version) {
        this.version = removeUselessCaract(version);
        this.nameDevice = nameDevice;
    }

    public String getVersion() {
        return version;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    /**
     * Remove all zero, dual point and final point in version number
     *
     * @param version String to modified
     * @return The string without zero, dual points and the last character is not a point
     */
    public String removeUselessCaract(String version) {
        if (version == null || version.isEmpty()) {
            return null;
        } else {
            String finalVersion = Utils.removeZero(version);
            finalVersion  = Utils.removeDualPoint(finalVersion);
            finalVersion = Utils.removeFinalPoint(finalVersion);
            return finalVersion;
        }
    }

}
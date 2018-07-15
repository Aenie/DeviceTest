package Tools;

import Device.Device;

import java.util.List;

public class ToolsVersion {

    /**
     * Sort list of devices by version
     *
     * @param listDevice List of device class
     * @return The list of devices sorted
     */
    static public List<Device> sortVersion(List<Device> listDevice) {
        Device temp;

        // Check if the list is empty or null
        if (listDevice == null || listDevice.isEmpty()) {
            return listDevice;
        }

        for (int i = 1; i < listDevice.size(); i++)
            for (int j = i; j > 0; j--)
                // Check if device class is not null
                if (listDevice.get(j) != null) {
                    if (compareVersion(listDevice.get(j).getVersion(), listDevice.get(j - 1).getVersion()) < 0) {
                        //Insertion sort on the given device to assign correct version numbers
                        temp = listDevice.get(j);
                        listDevice.set(j, listDevice.get(j - 1));
                        listDevice.set(j - 1, temp);
                    }
                }
        return listDevice;
    }

    /**
     * Compare version numbers breaking it apart into a String array
     *
     * @param version1 Version number 1 to compare
     * @param version2 Version number 2 to compare
     * @return Integer, 0 if versions is equals,
     *                  1 if version1 > version 2,
     *                 -1 if version 2 > version 1
     */
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version1.isEmpty()) return 1;
        if (version2 == null || version2.isEmpty()) return 1;

        // Version numbers breaking it apart into a String array
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;

        while (i < arr1.length || i < arr2.length) {
            if (i < arr1.length && i < arr2.length) {
                if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                    return -1;
                } else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                    return 1;
                }
            } else if (i < arr1.length) {
                if (Integer.parseInt(arr1[i]) != 0) {
                    return 1;
                }
            } else if (i < arr2.length) {
                if (Integer.parseInt(arr2[i]) != 0) {
                    return -1;
                }
            }

            i++;
        }
        return 0;
    }
}

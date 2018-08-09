package Tools;

public class Utils {

    /**
     * Remove all character zero in a string
     *
     * @param stringToRemove String to modified
     * @return The string without character zero
     */
    static public String removeZero(String stringToRemove) {
        if (stringToRemove == null || stringToRemove.isEmpty()) {
            return null;
        }
        return stringToRemove.replace(".00", ".");
    }

    /**
     * Remove dual point in succession in a string
     *
     * @param stringToRemove String to modified
     * @return The string without points in succession
     */
    static public String removeDualPoint(String stringToRemove) {
        if (stringToRemove == null || stringToRemove.isEmpty()) {
            return null;
        }
        return stringToRemove.replace("..", ".");
    }

    /**
     * Delete the last character in a string if it is a point
     *
     * @param stringToRemove String to modified
     * @return The string without a last point
     */
    static public String removeFinalPoint(String stringToRemove) {
        if (stringToRemove == null || stringToRemove.isEmpty()) {
            return null;
        }
        if (stringToRemove.substring(stringToRemove.length() - 1).equals(".")) {
            stringToRemove = stringToRemove.substring(0, stringToRemove.lastIndexOf("."));
        }
        return stringToRemove;
    }
}
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Device.Device;
import Tools.ToolsVersion;
import Tools.Utils;

import static org.junit.Assert.*;

public class DevicesTest {

    @Test
    public void nullList() {
        assertNull ("Not supported null Object",
                ToolsVersion.sortVersion(null));
    }

    @Test
    public void emptyList() {
        assertTrue(" Not supported empty object",
                ToolsVersion.sortVersion(new ArrayList<Device>()).isEmpty());
    }

    @Test
    public void fullNullList() {
        ArrayList<Device> test = new ArrayList<Device>();
        test.add(null);
        test.add(null);
        test.add(null);
        List<Device> res = ToolsVersion.sortVersion(test);
        assertNull( "Not supported null Object", res.get(0));
        assertNull( "Not supported null Object", res.get(1));
        assertNull( "Not supported null Object", res.get(2));
    }

    @Test
    public void simpleList() {
        ArrayList<Device> test = new ArrayList<Device>();
        test.add(new Device("name1", "7.00"));
        test.add(new Device("name2", "7"));
        test.add(new Device("name3", "6.4.2"));
        List<Device> res = ToolsVersion.sortVersion(test);
        assertEquals("The value" + res.get(0).getVersion() + " and 6.4.2 is not equal",
                res.get(0).getVersion(), "6.4.2");
        assertEquals("The value" + res.get(1).getVersion() + " and 7 is not equal",
                res.get(1).getVersion(), "7");
        assertEquals("The value" + res.get(2).getVersion() + " and 7 is not equal",
                res.get(2).getVersion(), "7");
    }

    @Test
    public void simpleCompares() {
        Device great = new Device("name", "1");
        assertTrue(great.getVersion() + " is not superior to null",
                ToolsVersion.compareVersion(null, great.getVersion()) > 0);

        great = new Device("name1", "7");
        Device low = new Device("name2", "7.00");
        assertEquals("The value " + great.getVersion() + " and " + low.getVersion() + " is not equal",
                ToolsVersion.compareVersion(great.getVersion(), low.getVersion()), 0);
        assertEquals("The value " + great.getVersion() + " and " + low.getVersion() + " is not equal",
                ToolsVersion.compareVersion(low.getVersion(), great.getVersion()), 0);
    }

    @Test
    public void advanceCompares() {
        Device great = new Device("name1", "7.1");
        Device low = new Device("name2", "6.4.2");
        assertTrue(great.getVersion() + " is not superior to " + low.getVersion(),
                ToolsVersion.compareVersion(great.getVersion(), low.getVersion()) > 0);
        assertTrue(great.getVersion() + " is not inferior to " + low.getVersion(),
                ToolsVersion.compareVersion(low.getVersion(), great.getVersion()) < 0);

        great = new Device("name3", "7.0.1");
        low = new Device("name4", "7");
        assertTrue(great.getVersion() + " is not superior to " + low.getVersion(),
                ToolsVersion.compareVersion(great.getVersion(), low.getVersion()) > 0);
        assertTrue(great.getVersion() + " is not inferior to " + low.getVersion(),
                ToolsVersion.compareVersion(low.getVersion(), great.getVersion()) < 0);
    }

    @Test
    public void removeZeroTest() {
        assertNull ("Not supported null Object",
                Utils.removeZero(null));

        assertEquals("The value 10.00 and 10 is not equal",
                Utils.removeZero("10.00"), "10.");
    }

    @Test
    public void removeDualPoint() {
        assertNull ("Not supported null Object",
                Utils.removeDualPoint(null));

        assertEquals("The value 7..1 and 7.1 is not equal",
                Utils.removeDualPoint("7..1"),"7.1");
    }

    @Test
    public void removeFinalPoint() {
        assertNull ("Not supported null Object",
                Utils.removeFinalPoint(null));

        assertEquals("The value 7. and 7 is not equal",
                Utils.removeFinalPoint("7."), "7");
    }
}

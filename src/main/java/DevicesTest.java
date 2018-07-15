import Device.Device;
import Tools.ToolsVersion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DevicesTest {

    public static void main(String[] args) {
        //Testing
        ArrayList<Device> test = new ArrayList<Device>();
        test.add(new Device("a", "7.00"));
        test.add(new Device("b", "7"));
        test.add(new Device("c", "6.0.2"));
        List<Device> res = ToolsVersion.sortVersion(test);


        for (Iterator iter = res.iterator(); iter.hasNext(); ) {
            Device dev = (Device) iter.next();
            System.out.println("version = " + dev.getVersion() + " name: " + dev.getNameDevice());
        }
    }
}
